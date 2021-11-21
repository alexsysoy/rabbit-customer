package com.example.rabbitcustomer.domain

class Order (
    /**
     * Уникальный идентификатор заказа на стороне ретейлера
     */
    val id: String,

    /**
     * Произвольный адрес доставки
     */
    val address: String,

    /**
     * Произвольный получатель доставки
     */
    val recipient: String,

    /**
     * Список заказанных товаров
     */
    val items: List<Item>
){
    override fun toString(): String {
        return "Order(id='$id', address='$address', recipient='$recipient', items=$items)"
    }
}