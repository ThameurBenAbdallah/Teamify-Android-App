package com.example.teamify.navigation

sealed class TeamifyScreens(val route: String){
    object UsersScreen: TeamifyScreens("All users")
    object SignUpScreen: TeamifyScreens("Sign up")
    object SignInScreen: TeamifyScreens("Sign In")
}
