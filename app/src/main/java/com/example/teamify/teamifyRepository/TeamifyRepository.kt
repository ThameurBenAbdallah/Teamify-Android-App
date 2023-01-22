package com.example.teamify.teamifyRepository
import com.example.teamify.authObjects.AuthResult
import com.example.teamify.authObjects.UpRequest
import com.example.teamify.models.User
import kotlinx.coroutines.flow.Flow

interface TeamifyRepository {
    suspend fun signUp(upRequest: UpRequest): AuthResult<Unit>
    suspend fun signIn(userEmail: String, password: String):AuthResult<Unit>
    fun users(): Flow<AuthResult<Flow<List<User>>>>
    suspend fun user(id: Int):AuthResult<User>
    suspend fun authenticate(): AuthResult<String>

}