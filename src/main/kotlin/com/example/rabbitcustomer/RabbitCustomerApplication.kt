package com.example.rabbitcustomer

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class RabbitCustomerApplication{

	@Bean
	fun customer(): Customer {
		return Customer()
	}
}

fun main(args: Array<String>) {
    runApplication<RabbitCustomerApplication>(*args)
}
