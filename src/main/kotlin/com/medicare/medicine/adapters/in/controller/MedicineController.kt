package com.medicare.medicine.adapters.`in`.controller

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin(origins = ["*"], allowedHeaders = ["*"])
@RestController
@RequestMapping("/medicine")
class MedicineController {

    @GetMapping
    fun sayHello(): String {
        return "Hello, Medicine!"
    }
    @GetMapping("/teste")
    fun sayHell2o(): String {
        return "Hello, Medicine 2!"
    }
}