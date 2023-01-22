@file:Suppress("UNUSED_EXPRESSION")

package com.example.teamify.uiTeamify.screens


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.teamify.authObjects.AuthRequest
import com.example.teamify.navigation.TeamifyScreens
import com.example.teamify.uiTeamify.TeamifyViewModel


@Composable

fun SignInScreen(viewModel: TeamifyViewModel = hiltViewModel(), navigateToUsersScreens: () -> Unit)
{
    var password by remember { mutableStateOf("") }
    var userEmail by remember { mutableStateOf("") }
    val focusRequester = FocusRequester()


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        OutlinedTextField(
            value = userEmail,
            onValueChange = { userEmail = it },
            placeholder = {
                Text(
                    text = ("Enter your email")
                )
            },
            label = { Text(text = "Email") },
            leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "emailIcon") },
            modifier = Modifier.focusRequester(focusRequester).fillMaxWidth().height(72.dp)

        )
        Spacer(
            modifier = Modifier.height(24.dp)
        )
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            placeholder = {
                Text(
                    text = ("Enter your password")
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            label = { Text(text = "Password") },
            modifier = Modifier.fillMaxWidth().height(72.dp)


        )
        Spacer(
            modifier = Modifier.height(24.dp)
        )
        Button(onClick = {
            viewModel.run { viewModel.signIn( AuthRequest(email= userEmail, password= password)) }
            navigateToUsersScreens()
        }) {

            }


    }
}







