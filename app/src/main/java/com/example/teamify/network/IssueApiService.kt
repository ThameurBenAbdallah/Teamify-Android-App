package com.example.teamify.network

import com.example.teamify.models.Subproject
import retrofit2.Call
import retrofit2.http.*


interface IssueApiService {
    @GET("/issues")
    suspend fun getIssues(): Call<List<Subproject>>

    @POST("/issues")
    suspend fun createIssue(@Body Subproject: Subproject): Call<Subproject>

    @PUT("/issues/{id}")
    suspend fun updateIssue(@Path("id") id: String, @Body Subproject: Subproject): Call<Subproject>

    @DELETE("/issues/{id}")
    suspend fun deleteIssue(@Path("id") id: String): Call<Void>
}