package com.beiconbsb.data.splash

import com.google.firebase.auth.FirebaseAuth

class SplashDataSource {

    suspend fun isUserLogged(): Boolean {
        return FirebaseAuth.getInstance().currentUser != null
    }
}