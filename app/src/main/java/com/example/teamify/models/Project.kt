package com.example.teamify.models

import kotlinx.serialization.Serializable

@Serializable
data class Project(val id: Int,
                   val title: String,
                   val startTime: String,
                   val endTime: String,
                   val description: String
)