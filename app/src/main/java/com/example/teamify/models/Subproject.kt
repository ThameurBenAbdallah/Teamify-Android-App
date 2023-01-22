package com.example.teamify.models

import kotlinx.serialization.Serializable

@Serializable
data class Subproject(
    val id: Int,
    val title: String,
    val endTime: String,
    val projectId: Int,
)