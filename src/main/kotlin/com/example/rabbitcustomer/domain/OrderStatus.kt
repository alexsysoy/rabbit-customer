package com.example.rabbitcustomer.domain

/**
 * Возможные статусы заказа
 */
enum class OrderStatus {
    SENT,
    CREATED,
    DELIVERED,
    ERROR
}