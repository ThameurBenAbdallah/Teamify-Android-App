package com.example.teamify.network

import com.example.teamify.authObjects.AuthRequest
import com.example.teamify.authObjects.TokenResponse
import com.example.teamify.authObjects.UpRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface AuthApiService {
    @POST("signup")
    suspend fun signUp(
        @Body request: UpRequest
    )

    @POST("signin")
    suspend fun signIn(
        @Body request: AuthRequest
    ): TokenResponse

    @GET("user")
    suspend fun authenticate(
        @Header("Authorization") token: String
    )
}
