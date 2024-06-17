package com.example.loginreqres.domain.login

interface LoginRepository {

    suspend fun login(): Result<Unit>
}