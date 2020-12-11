package com.rrdev.data_remote.service

import com.rrdev.data_remote.model.LogInBodyRequest
import com.rrdev.data_remote.model.LogInResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthenticationWebService {
    @POST("users/auth/sign_in")
    fun logIn(@Body body: LogInBodyRequest): Call<LogInResponse>
}