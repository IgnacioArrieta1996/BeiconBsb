package com.beiconbsb.ui.logout

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.beiconbsb.core.Status
import com.beiconbsb.data.firebaseAuth.logout.LogOutRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class LogOutViewModel @Inject constructor(private val logOutRepository: LogOutRepository) :
    ViewModel() {

    fun logOut() = liveData(Dispatchers.IO) {
        emit(Status.Loading())

        try {
            emit(Status.Success(logOutRepository.logOut()))
        } catch (e: Exception) {
            emit(Status.Failure(e))
        }
    }
}