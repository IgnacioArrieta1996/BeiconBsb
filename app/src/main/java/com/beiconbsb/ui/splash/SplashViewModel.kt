package com.beiconbsb.ui.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.beiconbsb.core.Status
import com.beiconbsb.data.splash.SplashRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val splashRepository: SplashRepository) :
    ViewModel() {

    fun isUserLogged() = liveData(Dispatchers.IO) {

        emit(Status.Loading())

        try {
            emit(Status.Success(splashRepository.isUserLogged()))
        } catch (e: Exception) {
            emit(Status.Failure(e))
        }
    }
}

