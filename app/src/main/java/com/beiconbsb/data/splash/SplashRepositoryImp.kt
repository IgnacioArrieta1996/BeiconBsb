package com.beiconbsb.data.splash

import javax.inject.Inject

class SplashRepositoryImp @Inject constructor(val splashDataSource: SplashDataSource) : SplashRepository {

    override suspend fun isUserLogged() = splashDataSource.isUserLogged()
}