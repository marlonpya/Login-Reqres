package com.example.loginreqres.data.model

import com.google.gson.annotations.SerializedName

data class ContactsResponse(
    @SerializedName("data") val data: List<ContactResponse>,
)

data class ContactResponse(
    @SerializedName("id") val id: String?,
    @SerializedName("email") val email: String?,
    @SerializedName("first_name") val firstName: String?,
    @SerializedName("last_name") val lastName: String?,
    @SerializedName("avatar") val avatar: String?,
)