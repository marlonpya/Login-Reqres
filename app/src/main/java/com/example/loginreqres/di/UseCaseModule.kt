package com.example.loginreqres.di

import com.example.loginreqres.domain.contact.ContactRepository
import com.example.loginreqres.domain.login.LoginRepository
import com.example.loginreqres.domain.usecase.ContactUseCase
import com.example.loginreqres.domain.usecase.LoginUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun provideLoginUseCase(repository: LoginRepository): LoginUseCase {
        return LoginUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideContactUseCase(repository: ContactRepository): ContactUseCase {
        return ContactUseCase(repository)
    }
}