package com.beiconbsb.data.firebaseAuth.signup

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.tasks.await


class SignUpDataSource {

    suspend fun signUp(email: String, password: String) : FirebaseUser? {
        val signUpResult = FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password).await()
        return signUpResult.user
    }
}