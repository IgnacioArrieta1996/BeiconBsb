package com.beiconbsb.data.model

data class User(
    val userId: String = "",
    val userName: String,
    val userLastName: String = "",
    val userEmail: String = "",
    val userPhone: String = "",
    val userAddress: String = ""
) {}