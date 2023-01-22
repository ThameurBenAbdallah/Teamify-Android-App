package com.example.teamify.uiTeamify



data class AuthState(
    val isLoading: Boolean = false,
    val signUpUserEmail: String = "",
    val signUpUsername: String = "",
    val signUpPassword: String = "",
    val signInUsername: String = "",
    val signInPassword: String = "",
)