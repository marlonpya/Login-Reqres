package com.example.loginreqres.di

import com.example.loginreqres.data.contact.ContactRepositoryImpl
import com.example.loginreqres.data.login.LoginRepositoryImpl
import com.example.loginreqres.data.remote.ReqresService
import com.example.loginreqres.domain.contact.ContactRepository
import com.example.loginreqres.domain.login.LoginRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideLoginRepository(
        reqresService: ReqresService
    ): LoginRepository = LoginRepositoryImpl(reqresService)

    @Singleton
    @Provides
    fun provideContactsRepository(
        reqresService: ReqresService
    ): ContactRepository = ContactRepositoryImpl(reqresService)
}
