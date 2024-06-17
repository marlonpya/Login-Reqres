package com.example.loginreqres.data.remote

import com.example.loginreqres.data.model.ContactsResponse
import com.example.loginreqres.data.model.LoginRequest
import com.example.loginreqres.data.model.ReqresResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface ReqresService {

    @Headers("Content-Type: application/json")
    @POST("login")
    fun getUser(@Body body: LoginRequest): Call<ReqresResponse?>

    @Headers("Content-Type: application/json")
    @GET("users?page=1")
    fun getContacts(): Call<ContactsResponse?>

    companion object {

        const val LOGIN = "login"
        const val GET_CONTACTS = "users?page=1"
    }
}