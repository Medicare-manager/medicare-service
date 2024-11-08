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
    @GetMapping
    fun sayHello(): String {
        return "Hello, Medicine!"
    }

    @Operation(summary = "Retorna uma mensagem de boas-vindas 2")
    @GetMapping("/teste")
    fun sayHell2o(): String {
        return "Hello, Medicine 2!"
    }
}