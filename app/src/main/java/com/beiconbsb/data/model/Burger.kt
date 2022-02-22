package com.beiconbsb.data.model

data class Burger(
    val id: String = "",
    val clientName: String = "",
    val burgerSize: String = "",
    val toppingList: List<Toppings>,
    val dressingList: List<Dressing>
) {
}