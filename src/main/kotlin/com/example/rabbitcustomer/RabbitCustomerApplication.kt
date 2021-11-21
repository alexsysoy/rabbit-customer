package com.example.rabbitcustomer

import com.example.rabbitcustomer.config.RabbitAmqpRunner
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Profile
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class RabbitCustomerApplication{

	@Bean
	fun usage() = CommandLineRunner{
		println("This app uses Spring Profiles to control its behavior.")
		println("Sample usage: java -jar rabbitapp.jar --app.client.name=ivan")
	}

//	@Bean
//	fun tutorial(): CommandLineRunner {
//		return RabbitAmqpRunner()
//	}

	@Bean
	fun customer(): Customer {
		return Customer()
	}

}

fun main(args: Array<String>) {
    runApplication<RabbitCustomerApplication>(*args)
}
