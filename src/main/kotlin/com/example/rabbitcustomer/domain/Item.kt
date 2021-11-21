package com.example.rabbitcustomer.domain

class Item(
    /**
     * Произвольный идентификатор
     */
    val id: Long,

    /**
     * Произвольное название
     */
    val name: String
){
    override fun toString(): String {
        return "Item(id=$id, name='$name')"
    }
}
