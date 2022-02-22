package com.beiconbsb.data.firebaseAuth.signup

import com.google.firebase.auth.FirebaseUser

interface SignUpRepository {

    suspend fun signUp(email: String, password: String): FirebaseUser?


}