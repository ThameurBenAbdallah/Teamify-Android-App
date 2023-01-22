package com.example.teamify.network

import com.example.teamify.authObjects.TokenResponse
import com.example.teamify.models.User
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.http.*

interface UserApiService {

    @GET("/users")

    fun getUsers(): Flow<List<User>>

    @POST("/users")
    suspend fun createUser(@Header("Authorization") @Body user: User): User

    @PUT("/users/{id}")
    suspend fun updateUser(@Header("Authorization") @Path("id") id: String, @Body user: User): User

    @DELETE("/users/{id}")
    suspend fun deleteUser(@Header("Authorization") @Path("id") id: String): Void
}

