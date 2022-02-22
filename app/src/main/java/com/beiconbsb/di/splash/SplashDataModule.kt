package com.beiconbsb.di.splash

import com.beiconbsb.data.splash.SplashDataSource
import com.beiconbsb.data.splash.SplashRepository
import com.beiconbsb.data.splash.SplashRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class SplashDataModule {

    @Provides
    fun providesSplashDataSource() = SplashDataSource()
}


@Module
@InstallIn(SingletonComponent::class)
abstract class SplashViewModelData {

    @Binds
    abstract fun bindSignUpRepositoryImp(splashRepositoryImp: SplashRepositoryImp): SplashRepository
}
