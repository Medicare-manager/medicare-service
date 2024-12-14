package com.medicare.medicine.infraestructure.config.security

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.exceptions.JWTVerificationException
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.time.ZoneOffset

@Service
class TokenService {

    @Value("\${api.security.token.secret}")
    private lateinit var secret: String

    private val tokenBlacklist = mutableSetOf<String>()

    fun generateToken(email: String): String {
        try {
            val algorithm = Algorithm.HMAC256(secret)
            return JWT.create()
                .withIssuer("Smart-Spending")
                .withSubject(email)
                .withExpiresAt(genExpirationDate())
                .sign(algorithm)
        } catch (exception: Exception) {
            throw RuntimeException("Error while generating token", exception)
        }
    }

    fun validateToken(token: String): String? {
        try {
            val algorithm = Algorithm.HMAC256(secret)
            val subject = JWT.require(algorithm)
                .withIssuer("Smart-Spending")
                .build()
                .verify(token)
                .subject

            if (tokenBlacklist.contains(token)) {
                throw JWTVerificationException("Token in blacklist")
            }

            return subject
        } catch (exception: JWTVerificationException) {
            println("Erro na validação do token: ${exception.message}")
            return null
        }
    }

    fun addToBlacklist(token: String) {
        tokenBlacklist.add(token)
    }

    fun isTokenBlacklisted(token: String): Boolean {
        return tokenBlacklist.contains(token)
    }

    private fun genExpirationDate(): java.util.Date {
        return java.util.Date.from(
            LocalDateTime.now().plusHours(8).toInstant(ZoneOffset.of("-03:00"))
        )
    }
}