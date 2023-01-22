package com.example.teamify.models

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: Int,
    val email: String,
    val fullName: String,
    val password: String,
    val role:Role
)