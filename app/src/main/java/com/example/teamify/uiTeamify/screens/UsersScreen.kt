package com.example.teamify.uiTeamify.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ExperimentalComposeApi
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.teamify.uiTeamify.TeamifyViewModel
import com.example.teamify.uiTeamify.uiComponents.UserCard
import com.example.teamify.uiTeamify.uiComponents.UsersTopBar

@ExperimentalMaterialApi
@ExperimentalComposeApi
@Composable
fun UsersScreen(viewModel: TeamifyViewModel){

    val users by viewModel.getAllUsers().collectAsState(initial = emptyList())

    Scaffold(
        topBar = {
            UsersTopBar()
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            items(
                items = users
            ) { user ->
                UserCard(
                    user = user,
                    )
            }
        }

//            AddTaskAlertDialog(
//                openDialog = viewModel.openDialog,
//                closeDialog = {
//                    viewModel.closeDialog()
//                },
//                addTask = { user ->
//                    viewModel.addTask(task)
//                }
//            )
    }
//        , floatingActionButton = {
//            AddUserFloatingActionButton(
//                openDialog = {
//                    viewModel.openDialog()
//                }
//            )
//        }

}
