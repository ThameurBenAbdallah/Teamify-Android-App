package com.example.teamify.models

import kotlinx.serialization.Serializable

@Serializable
data class Team(val id: Int,
                val name: String,
)