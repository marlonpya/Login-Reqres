package com.example.loginreqres.domain.usecase

import com.example.loginreqres.data.model.ContactResponse
import com.example.loginreqres.domain.contact.ContactRepository
import javax.inject.Inject

class ContactUseCase @Inject constructor(
    private val repository: ContactRepository
) {
    suspend operator fun invoke(): Result<List<ContactResponse?>> = repository.getContacts()
}