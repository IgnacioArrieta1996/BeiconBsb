package com.beiconbsb.data.firebaseAuth.signup

import com.beiconbsb.data.firebaseAuth.signup.SignUpDataSource
import com.beiconbsb.data.firebaseAuth.signup.SignUpRepository
import com.google.firebase.auth.FirebaseUser
import javax.inject.Inject

class SignUpRepositoryImp @Inject constructor(val dataSource: SignUpDataSource) : SignUpRepository {

    override suspend fun signUp(email: String, password: String): FirebaseUser? =
        dataSource.signUp(email, password)

}