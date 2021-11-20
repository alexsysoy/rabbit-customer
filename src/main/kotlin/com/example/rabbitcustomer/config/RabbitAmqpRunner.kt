package com.example.rabbitcustomer.config

import org.slf4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.context.ConfigurableApplicationContext

class RabbitAmqpRunner : CommandLineRunner {

    @Autowired
    lateinit var logger: Logger

    @Value("\${app.client.name:ivan}")
    val clientName = "petya"

    @Autowired
    lateinit var ctx: ConfigurableApplicationContext

    override fun run(vararg args: String?) {
        logger.info(" [x] Client name is: $clientName")
        ctx.close()
    }
}
