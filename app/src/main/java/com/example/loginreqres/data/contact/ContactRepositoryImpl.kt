package com.example.loginreqres.data.contact

import com.example.loginreqres.data.model.ContactResponse
import com.example.loginreqres.data.remote.ReqresService
import com.example.loginreqres.domain.contact.ContactRepository
import java.io.IOException
import javax.inject.Inject

class ContactRepositoryImpl @Inject constructor(
    private val service: ReqresService
) : ContactRepository {

    override suspend fun getContacts(): Result<List<ContactResponse?>> {
        return try {
            val response = service.getContacts()
            val fact = response.execute().body()
            return if (fact != null) Result.success(fact.data) else Result.failure(
                IOException("Data is null")
            )
        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }

}