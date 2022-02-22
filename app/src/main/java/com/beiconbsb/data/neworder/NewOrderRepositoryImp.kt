package com.beiconbsb.data.neworder

import com.beiconbsb.data.model.BurgerFirestore
import javax.inject.Inject

class NewOrderRepositoryImp @Inject constructor(private val newOrderDataSource: NewOrderDataSource) :
    NewOrderRepository {

    override suspend fun getBurgerList() = newOrderDataSource.getBurgerList()

    override suspend fun getVeggieBurgersList() = newOrderDataSource.getVeggieBurgerList()

}
