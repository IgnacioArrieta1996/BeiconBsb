package com.beiconbsb.di.neworder

import com.beiconbsb.data.neworder.NewOrderDataSource
import com.beiconbsb.data.neworder.NewOrderRepository
import com.beiconbsb.data.neworder.NewOrderRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class NewOrderDataModule {

    @Provides
    fun providesNewOrderDataSource() = NewOrderDataSource()

}


@Module
@InstallIn(SingletonComponent::class)
abstract class NewOrderViewModelData {

    @Binds
    abstract fun bindSignUpRepositoryImp(newOrderRepositoryImp: NewOrderRepositoryImp): NewOrderRepository
}
