package com.beiconbsb.ui.neworder

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.beiconbsb.core.Status
import com.beiconbsb.data.neworder.NewOrderRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class NewOrderViewModel @Inject constructor(private val newOrderRepository: NewOrderRepository) : ViewModel() {


    fun getAvaliableBurgerList() = liveData(Dispatchers.IO) {

        emit(Status.Loading())

        try {
            emit(Status.Success(newOrderRepository.getBurgerList()))
        } catch (e: Exception){
            emit(Status.Failure(e))
        }

    }


    fun getVeggieBurgerList() = liveData(Dispatchers.IO) {

        emit(Status.Loading())

        try {
            emit(Status.Success(newOrderRepository.getVeggieBurgersList()))
        } catch (e: Exception){
            emit(Status.Failure(e))
        }

    }


}