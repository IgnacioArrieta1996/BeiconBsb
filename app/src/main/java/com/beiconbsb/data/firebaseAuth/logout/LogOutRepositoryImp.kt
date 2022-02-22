package com.beiconbsb.data.firebaseAuth.logout

import javax.inject.Inject

class LogOutRepositoryImp @Inject constructor(private val logOutDataSource: LogOutDataSource): LogOutRepository {

    override suspend fun logOut() {
            logOutDataSource.logOut()
    }
}