package com.beiconbsb.data.model

data class MyOrders(
    val orderId: String = "",
    val orderName: String = "",
    val burgerList: List<Burger>,
) {
}