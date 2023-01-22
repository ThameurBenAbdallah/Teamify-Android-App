package com.example.teamify.models

import kotlinx.serialization.Serializable

@Serializable
data class Milestone(
    val id: Int,
    val title: String,
    val startTime: String,
    val endTime: String,
    val dueTime: String,
    val subprojectId: Int,
    val description: String
)