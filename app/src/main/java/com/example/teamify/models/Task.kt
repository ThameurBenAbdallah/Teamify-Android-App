package com.example.teamify.models

import kotlinx.serialization.Serializable

@Serializable
data class Task(
    val id: Int,
    val milestone: Milestone,
    val teamMember: TeamMember,
    val startTime: String,
    val dueTime: String,
    val endTime: String,
    val description: String,
    val priority: String,
    val status: String
)