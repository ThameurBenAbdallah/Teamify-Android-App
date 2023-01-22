package com.example.teamify.network

import com.example.teamify.models.Subproject
import retrofit2.http.*
import retrofit2.Call

interface SubprojectApiService {
    @GET("/subprojects")
    suspend fun getSubprojects(): Call<List<Subproject>>

    @POST("/subprojects")
    suspend fun createSubproject(@Body Subproject: Subproject): Call<Subproject>

    @PUT("/subprojects/{id}")
    suspend fun updateSubproject(@Path("id") id: String, @Body Subproject: Subproject): Call<Subproject>

    @DELETE("/subprojects/{id}")
    suspend fun deleteSubproject(@Path("id") id: String): Call<Void>
}