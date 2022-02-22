package com.beiconbsb.data.firebaseAuth.logout

import com.google.firebase.auth.FirebaseAuth

class LogOutDataSource {

    suspend fun logOut() {
        FirebaseAuth.getInstance().signOut()
    }
}