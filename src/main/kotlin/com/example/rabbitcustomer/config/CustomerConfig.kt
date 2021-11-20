package com.example.rabbitcustomer.config

import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CustomerConfig {

    @Bean
    fun logger() = LoggerFactory.getLogger(javaClass)
}