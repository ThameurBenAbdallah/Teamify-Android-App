package com.example.teamify.network

import com.example.teamify.models.TeamMember
import retrofit2.Call
import retrofit2.http.*

interface TeamMemberApiService {
    @GET("/teamMembers")
    suspend fun getTeamMembers(): Call<List<TeamMember>>

    @POST("/teamMembers")
    suspend fun createTeamMember(@Body teamMember: TeamMember): Call<TeamMember>

    @PUT("/teamMembers/{id}")
    suspend fun updateTeamMember(@Path("id") id: String, @Body teamMember: TeamMember): Call<TeamMember>

    @DELETE("/teamMembers/{id}")
    suspend fun deleteTeamMember(@Path("id") id: String): Call<Void>

}