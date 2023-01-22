package com.example.teamify.network

import com.example.teamify.models.Task
import retrofit2.Call
import retrofit2.http.*

interface TaskApiService {

    @GET("/tasks")
    suspend fun getTasks(): Call<List<Task>>

    @POST("/tasks")
    suspend fun createTask(@Body Task: Task): Call<Task>

    @PUT("/tasks/{id}")
    suspend fun updateTask(@Path("id") id: String, @Body Task: Task): Call<Task>

    @DELETE("/tasks/{id}")
    suspend fun deleteTask(@Path("id") id: String): Call<Void>

}
