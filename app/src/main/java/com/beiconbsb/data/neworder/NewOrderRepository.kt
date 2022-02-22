package com.beiconbsb.data.neworder

import com.beiconbsb.data.model.BurgerFirestore

interface NewOrderRepository {

    suspend fun getBurgerList() : List<BurgerFirestore>

    suspend fun getVeggieBurgersList(): List<BurgerFirestore>
}