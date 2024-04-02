package com.propokeignintion.cardrules.di


import com.propokeignintion.cardrules.data.repository.SharedRepositoryImpl
import com.propokeignintion.cardrules.domain.repository.SharedRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class DiModule {


    @Binds
    @Singleton
    abstract fun bindSharedRepository(sharedRepositoryImpl: SharedRepositoryImpl): SharedRepository
}