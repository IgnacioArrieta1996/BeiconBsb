package com.beiconbsb.core

import java.lang.Exception

sealed class Status<out T> {

    class Loading<out T>: Status<T>()
    data class Success<out T>(val data: T): Status<T>()
    data class Failure(val exception: Exception): Status<Nothing>()
}