package com.example.teamify.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.teamify.uiTeamify.screens.SignInScreen
import com.example.teamify.uiTeamify.screens.SignUpScreen


@Composable
@ExperimentalMaterialApi
fun NavGraph (
    navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = TeamifyScreens.SignUpScreen.route
    ) {
        composable(
            route = TeamifyScreens.SignUpScreen.route
        ) {
            SignUpScreen {

                navController.navigate(TeamifyScreens.SignInScreen.route)
            }
        }
        composable(
            route = TeamifyScreens.SignInScreen.route
            )
        {
            SignInScreen {
            navController.navigate(TeamifyScreens.UsersScreen.route)
            }
        }
        composable(
            route = TeamifyScreens.UsersScreen.route
        ){

        }

    }
}