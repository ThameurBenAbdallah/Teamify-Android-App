package com.example.teamify.network

import com.example.teamify.models.Subproject
import retrofit2.http.*
import retrofit2.Call

interface MilestoneApiService {
    @GET("/milestones")
    suspend fun getMilestones(): Call<List<Subproject>>

    @POST("/milestones")
    suspend fun createSubproject(@Body Subproject: Subproject): Call<Subproject>

    @PUT("/milestones/{id}")
    suspend fun updateSubproject(@Path("id") id: String, @Body Subproject: Subproject): Call<Subproject>

    @DELETE("/milestones/{id}")
    suspend fun deleteSubproject(@Path("id") id: String): Call<Void>
}