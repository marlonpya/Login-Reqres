package com.example.loginreqres.data.model

import com.google.gson.annotations.SerializedName

data class ReqresResponse(
    @SerializedName("token") val token: String?,
    @SerializedName("message") val message: String?
)