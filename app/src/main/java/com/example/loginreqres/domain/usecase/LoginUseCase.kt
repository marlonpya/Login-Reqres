package com.example.loginreqres.domain.usecase

import com.example.loginreqres.domain.login.LoginRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository: LoginRepository
) {
    suspend operator fun invoke(): Result<Unit> = repository.login()
}