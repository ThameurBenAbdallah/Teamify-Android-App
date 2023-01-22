package com.example.teamify.uiTeamify
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.teamify.authObjects.AuthRequest
import com.example.teamify.authObjects.AuthResult
import com.example.teamify.authObjects.UpRequest
import com.example.teamify.models.User
import com.example.teamify.teamifyRepository.TeamifyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class TeamifyViewModel  @Inject constructor(private val repository: TeamifyRepository) : ViewModel() {

    var state by mutableStateOf(AuthState())


    private val responseChannel = Channel<AuthResult<Unit>>()
    private val authResponseChannel = Channel<AuthResult<String>>()
    val responses = responseChannel.receiveAsFlow()


    /**
     * Verify if there is a JWT token for signing in
     */
    private lateinit var upResponse: AuthResult<Unit>
    private lateinit var authResponse: AuthResult<String>

    init {
        authenticate()
    }


    /**
     * Sign Up Route for first time access by an Administrator
     */
    fun signUp() {

        viewModelScope.launch {
            val signUpRequest = UpRequest(fullName = state.signUpUsername,
                email = state.signUpUserEmail,
                password = state.signUpPassword)
            state = state.copy(isLoading = true)
            upResponse = repository.signUp(signUpRequest)
            responseChannel.send(upResponse)
            state.copy(isLoading = false)
        }

    }

    /**
     * Sign in Route
     * */

    fun signIn(signInRequest: AuthRequest) {
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            val result = repository.signIn(
                userEmail = state.signInUsername,
                password = state.signInPassword
            )
            responseChannel.send(result)
            state = state.copy(isLoading = false)
        }
    }

    private fun authenticate() {
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            authResponse = repository.authenticate()
            authResponseChannel.send(authResponse)
            state = state.copy(isLoading = false)
        }
    }

    /**
     * Get all users from the repository
     * */


    @ExperimentalCoroutinesApi
 //   fun getAllUsers(): Flow<List<User>> {

        //       val authResultFlow = repository.users()
//        return  authResultFlow.flatMapLatest { authResult ->
//            when (authResult) {
//                is AuthResult.Authorized -> authResult.data
//                else  -> flowOf(emptyList())
//            }
//        }
//        state = state.copy(isLoading = true)
//        var users : Flow<List<User>> = flowOf(emptyList())
//        val authResultFlow = repository.users()
//        viewModelScope.launch {
//            authResultFlow.collect { authResult ->
//                when (authResult) {
//                    is AuthResult.Authorized -> users = authResult.data!!
//                    is AuthResult.UnknownError -> return@collect
//                }
//            }
//
//
//        }
//
//        state = state.copy(isLoading = false)
//        return users
//
//    }
        fun getAllUsers(): Flow<List<User>> {

            val authResultFlow = repository.users()
            return authResultFlow.flatMapLatest { authResult ->
                withContext(Dispatchers.IO) {
                    when (authResult) {
                        is AuthResult.Authorized -> authResult.data!!
                        else -> flowOf(emptyList())
                    }
                }
            }
        }
}


