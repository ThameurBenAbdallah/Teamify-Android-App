package com.example.teamify.network

import com.example.teamify.models.Project
import retrofit2.http.*
import retrofit2.Call

interface ProjectApiService {
    @GET("/projects")
    suspend fun getProjects(): Call<List<Project>>

    @POST("/projects")
    suspend fun createProject(@Body Project: Project): Call<Project>

    @PUT("/projects/{id}")
    suspend fun updateProject(@Path("id") id: String, @Body Project: Project): Call<Project>

    @DELETE("/projects/{id}")
    suspend fun deleteProject(@Path("id") id: String): Call<Void>

}