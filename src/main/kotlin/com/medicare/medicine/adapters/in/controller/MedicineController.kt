package com.medicare.medicine.adapters.`in`.controller

import io.swagger.v3.oas.annotations.Operation
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin(origins = ["*"], allowedHeaders = ["*"])
@RestController
@RequestMapping("/medicine")
class MedicineController {

    @Operation(summary = "Retorna uma mensagem de boas-vindas")
    @GetMapping("/testeRotaPriv")
    fun sayHello(): String {
        return "Hello, rota privada!"
    }

    @Operation(summary = "Retorna uma mensagem de boas-vindas 2")
    @GetMapping("/teste")
    fun sayHell2o(): String {
        return "Hello, rota pública!"
    }
}