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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.teamify.uiTeamify.TeamifyViewModel
import kotlinx.coroutines.job
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun SignUpScreen(
    viewModel: TeamifyViewModel = hiltViewModel(),
    navigateToSignInScreen: () -> Unit
) {
    var userFullName by remember { mutableStateOf("") }
    var userEmail by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val focusRequester = FocusRequester()





    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = userFullName,
            onValueChange = { userFullName = it },
            placeholder = {
                Text(
                    text = ("User full name")
                )
            },

            modifier = Modifier.focusRequester(focusRequester).fillMaxWidth().height(72.dp)
        )
        LaunchedEffect(Unit) {
            coroutineContext.job.invokeOnCompletion {
                focusRequester.requestFocus()
            }
        }
        Spacer(
            modifier = Modifier.height(24.dp)
        )
        OutlinedTextField(
            value = userEmail,
            onValueChange = { userEmail = it },
            placeholder = {
                Text(
                    text = ("Enter your email")
                )
            },
            leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "emailIcon") },
            modifier = Modifier.fillMaxWidth().height(72.dp)
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
            label = { Text(text = "Password") },
            modifier = Modifier.fillMaxWidth().height(72.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Button(onClick = {
            viewModel.state.copy(signUpUserEmail=userEmail,signUpUsername=userFullName, signUpPassword = password)
            viewModel.signUp()
            navigateToSignInScreen()}) {

        }
    }
}
