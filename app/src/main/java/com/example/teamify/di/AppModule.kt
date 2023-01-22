package com.example.teamify.di

import android.app.Application
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.example.teamify.network.TeamifyApi
import com.example.teamify.teamifyRepository.TeamifyRepository
import com.example.teamify.teamifyRepository.TeamifyRepositoryImp
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @ExperimentalSerializationApi
    @Provides
    @Singleton
    fun provideTeamifyApi(): TeamifyApi {
        return Retrofit.Builder()
            .baseUrl("http://192.168.1.12:5000/")
            .addConverterFactory(Json.asConverterFactory(MediaType.get("application/json")))
            .build()
            .create()
    }
    @Provides
    @Singleton
    fun provideSharedPref(app: Application): SharedPreferences {
        return app.getSharedPreferences("prefs", MODE_PRIVATE)
    }
    @Provides
    @Singleton
    fun provideTeamifyRepository(api: TeamifyApi, prefs: SharedPreferences): TeamifyRepository {
        return TeamifyRepositoryImp(api, prefs)
    }


}