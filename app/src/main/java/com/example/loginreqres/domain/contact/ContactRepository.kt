package com.example.loginreqres.domain.contact

import com.example.loginreqres.data.model.ContactResponse

interface ContactRepository {

    suspend fun getContacts(): Result<List<ContactResponse?>>
}