package com.example.loginreqres.data.login

import com.example.loginreqres.data.model.LoginRequest
import com.example.loginreqres.data.remote.ReqresService
import com.example.loginreqres.domain.login.LoginRepository
import java.io.IOException
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val service: ReqresService
): LoginRepository {

    override suspend fun login(): Result<Unit> {
        return try {
            val request = LoginRequest("eve.holt@reqres.in", "cityslicka")
            val response = service.getUser(request)
            val fact = response.execute().body()
            return if (fact != null) Result.success(Unit) else Result.failure(
                IOException("Data is null")
            )
        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }
}