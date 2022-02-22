package com.beiconbsb.di.auth.logout

import com.beiconbsb.data.firebaseAuth.logout.LogOutDataSource
import com.beiconbsb.data.firebaseAuth.logout.LogOutRepository
import com.beiconbsb.data.firebaseAuth.logout.LogOutRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class LogOutDataModule {

    @Provides
    fun provideLogOutDataSource() = LogOutDataSource()
}


@Module
@InstallIn(SingletonComponent::class)
abstract class LogOutViewModelData {

    @Binds
    abstract fun bindSignUpRepositoryImp(logOutRepositoryImp: LogOutRepositoryImp): LogOutRepository
}
