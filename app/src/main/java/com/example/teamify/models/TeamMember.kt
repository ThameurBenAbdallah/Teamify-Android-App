package com.example.teamify.models

import kotlinx.serialization.Serializable

@Serializable
data class TeamMember(
    val id: Int,
    val userId: Int,
    val teamId: Int,
    val role: String,
    val isTeamLeader: Boolean,
    val joinDate: String,
    val leaveDate: String
)