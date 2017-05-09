package com.github.kiptix.library

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class KotlinBootApplication

fun main(args: Array<String>) {
    SpringApplication.run(KotlinBootApplication::class.java, *args)
}
