package com.example.rabbitcustomer.domain
/**
 * Уведомление об изменении заказа
 */
data class OrderInfo(

    /**
     * Уникальный идентификатор заказа
     *
     * @see com.example.retailer.api.distributor.Item#id
     */
    val orderId: String,

    /**
     * Статус заказа:
     *  Created
     *
     */
    var status: OrderStatus,

    /**
     * Контрольная сумма
     */
    val signature: String,

    )