package com.example.teamify.uiTeamify.uiComponents


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.height
import androidx.compose.material.AlertDialog
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester

import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.teamify.models.Role

import com.example.teamify.models.User
import kotlinx.coroutines.job

import androidx.compose.material.Text as Text

@Composable
fun AddUserAlertDialog(
    openDialog: Boolean,
    closeDialog: () -> Unit,
    addUser: (user: User) -> Unit
) {
    if (openDialog) {
        var userFullName by remember { mutableStateOf("") }
        var userEmail by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var role: Role by remember { mutableStateOf(Role.TEAMMEMBER) }

        val focusRequester = FocusRequester()

        AlertDialog(
            onDismissRequest = closeDialog,
            title = {
                Text(
                    text = (stringResource(com.example.teamify.R.string.add_new_user))
                )
            },
            text = {
                Column {
                    TextField(
                        value = userFullName,
                        onValueChange = { userFullName = it },
                        placeholder = {
                            Text(
                                text = ("User full name")
                            )
                        },

                        modifier = Modifier.focusRequester(focusRequester)
                    )
                    LaunchedEffect(Unit) {
                        coroutineContext.job.invokeOnCompletion {
                            focusRequester.requestFocus()
                        }
                    }
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    TextField(
                        value = userEmail,
                        onValueChange = { userEmail = it },
                        placeholder = {
                            Text(
                                text = ("Enter the new user's email")
                            )
                        }
                    )
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    TextField(
                        value = password,
                        onValueChange = { password = it },
                        placeholder = {
                            Text(
                                text = ("Enter the new user's email")
                            )
                        }
                    )

                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        closeDialog()
                        val user = User(0,userEmail, userFullName, password, role)
                        addUser(user)
                    }
                ) {
                    Text(
                        text = "Add"
                    )
                }
            },
            dismissButton = {
                TextButton(
                    onClick = closeDialog
                ) {
                    Text(
                        text = "Dismiss"
                    )
                }
            }
        )
    }
}
