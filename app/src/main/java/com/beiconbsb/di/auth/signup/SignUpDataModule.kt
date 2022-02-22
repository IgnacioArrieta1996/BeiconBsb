package com.beiconbsb.di.auth.signup

import com.beiconbsb.data.firebaseAuth.signup.SignUpDataSource
import com.beiconbsb.data.firebaseAuth.signup.SignUpRepository
import com.beiconbsb.data.firebaseAuth.signup.SignUpRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class SignUpDataModule {

    @Provides
    fun provideSignUpDataSource() = SignUpDataSource()

}


@Module
@InstallIn(SingletonComponent::class)
abstract class SignUpViewModelData {

    @Binds
    abstract fun bindSignUpRepositoryImp(signUpRepositoryImp: SignUpRepositoryImp): SignUpRepository
}