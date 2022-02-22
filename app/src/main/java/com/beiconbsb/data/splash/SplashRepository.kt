package com.beiconbsb.data.splash

interface SplashRepository {

    suspend fun isUserLogged() : Boolean
}