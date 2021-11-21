package com.example.rabbitcustomer

import com.example.rabbitcustomer.domain.Item
import com.example.rabbitcustomer.domain.Order
import org.springframework.beans.factory.annotation.Value
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
        val random = Random().nextLong()
        val item1 = Item(random, "Pencil 11$random")
//        val item2 = Item(Random().nextLong(), "Sheets 100")

        val order = Order(
            clientName,
            "Peterburg $random",
            "Marshak $random",
            listOf(item1)
        )

        val headers = HttpHeaders()
        headers.setContentType(MediaType.APPLICATION_JSON)

        val request: HttpEntity<Order> = HttpEntity<Order>(order)
        restTemplate.postForObject("http://localhost:8080/placeOrder", request, Order::class.java)
    }

}
