package com.example.loginreqres.di

import com.example.loginreqres.data.remote.ReqresService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideSerivceApi(): ReqresService {
        return Retrofit.Builder()
            .baseUrl("https://reqres.in/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ReqresService::class.java)
    }

    companion object {
        const val BASE_URL = "https://cat-fact.herokuapp.com"
    }
}
