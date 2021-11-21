package com.example.rabbitcustomer

import com.example.rabbitcustomer.domain.Item
import com.example.rabbitcustomer.domain.Order
import com.example.rabbitcustomer.domain.OrderInfo
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.bind.Bindable.listOf
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.web.client.RestTemplate
import java.util.*

class Customer {

    @Value("\${app.client.name:ivan}")
    val clientName = "petya"

    val restTemplate: RestTemplate = RestTemplate()

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    fun send() {

        val cities = listOf("Petersburg", "Moscow", "Kasan", "Nizhniy Novgorod", "Ryazan", "Tula", "Vladivostok")
        val names = listOf("Ivanov", "Petorv", "Sidorov", "Karabaev", "Tutaev", "Vasiliev", "Pushkin", "Lermontov")
        val products = listOf("Pencil", "Paper", "Highliter", "Ruler", "Scissors", "Glue", "Eraser")
        val random = Random().nextInt(10000).toLong()
        val item1 = Item(random + 14, "${products.random()} ${random + 5}")
        val item2 = Item(random + 11, "${products.random()} ${random + 1}")

        val order = Order(
            clientName,
            "${cities.random()}",
            "${names.random()}",
            listOf(item1, item2)
        )

        val headers = HttpHeaders()
        headers.setContentType(MediaType.APPLICATION_JSON)
        val request = HttpEntity(order, headers)
        val response = restTemplate.postForObject("http://localhost:8080/placeOrder", request, OrderInfo::class.java)
        println(" [x] Send message")
    }
}
