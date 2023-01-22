package com.example.teamify.teamifyRepository
import android.content.SharedPreferences
import com.example.teamify.authObjects.AuthRequest
import com.example.teamify.authObjects.AuthResult
import com.example.teamify.authObjects.UpRequest
import com.example.teamify.models.User
import com.example.teamify.network.TeamifyApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import retrofit2.HttpException



class TeamifyRepositoryImp(private val api: TeamifyApi,
                           private val prefs: SharedPreferences
): TeamifyRepository{
    override suspend fun signUp(
        upRequest: UpRequest
    ): AuthResult<Unit> {
        return try {
            api.authApi.signUp(
                upRequest
            )
            signIn(upRequest.email, upRequest.password)
        } catch(e: HttpException) {
            if(e.code() == 401) {
                AuthResult.Unauthorized()
            } else {
                AuthResult.UnknownError()
            }
        } catch (e: Exception) {
            AuthResult.UnknownError()
        }

    }

    override suspend fun signIn(userEmail: String, password: String): AuthResult<Unit> {
        return try {
            val response = api.authApi.signIn(
                request = AuthRequest(
                    email = userEmail,
                    password = password
                )
            )
            prefs.edit()
                .putString("jwt", response.token)
                .apply()
            AuthResult.Authorized()
        } catch(e: HttpException) {
            if(e.code() == 401) {
                AuthResult.Unauthorized()
            } else {
                AuthResult.UnknownError()
            }
        } catch (e: Exception) {
            AuthResult.UnknownError()
        }

    }

    override fun users(): Flow<AuthResult<Flow<List<User>>>> {

        return flow{
            when(withContext(Dispatchers.IO) { authenticate() })
        {
            is AuthResult.Authorized -> {
                val users = api.userApi.getUsers()
                emit(AuthResult.Authorized(users))
        }
            is AuthResult.Unauthorized -> {
            emit(AuthResult.Unauthorized())
        }
            is AuthResult.UnknownError -> {
            emit(AuthResult.UnknownError())
        }
        }
    }






    }

    override suspend fun user(id: Int): AuthResult<User> {
        TODO("Not yet implemented")
    }

    override suspend fun authenticate(): AuthResult<String> {
        return try {
            val token = prefs.getString("jwt", null) ?: return AuthResult.Unauthorized()
            api.authApi.authenticate("Bearer $token")
            AuthResult.Authorized(token)
        } catch (e: HttpException) {
            if (e.code() == 401) {
                AuthResult.Unauthorized()
            } else {
                AuthResult.UnknownError()
            }
        } catch (e: Exception) {
            AuthResult.UnknownError()
        }
    }
}
