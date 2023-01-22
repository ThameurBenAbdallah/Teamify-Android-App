package com.example.teamify.network

import com.example.teamify.models.Team
import retrofit2.Call
import retrofit2.http.*


interface TeamApiService {
    @GET("/teams")
    suspend fun getTeams(): Call<List<Team>>

    @POST("/teams")
    suspend fun createTeam(@Body team: Team): Call<Team>

    @PUT("/teams/{id}")
    suspend fun updateTeam(@Path("id") id: String, @Body team: Team): Call<Team>

    @DELETE("/teams/{id}")
    suspend fun deleteTeam(@Path("id") id: String): Call<Void>

}