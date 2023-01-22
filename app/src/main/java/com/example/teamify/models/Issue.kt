package com.example.teamify.models

import kotlinx.serialization.Serializable

@Serializable
data class Issue(
    val id: Int,
    val taskId: Int,
    val title: String,
    val description: String,
    val status: String,
    val priority: String,
    val assigneeId: Int
)