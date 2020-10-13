package com.example.challangegok.base.di

import androidx.databinding.library.BuildConfig
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    @Named("baseUrl")
    fun provideBaseUrl(): String {
        return BASE_URL
    }

    @Provides
    @Singleton
    @Named("isDebuggable")
    fun provideIsDebuggable() = BuildConfig.DEBUG

    companion object{
        const val BASE_URL = "https://7hgi9vtkdc.execute-api.sa-east-1.amazonaws.com/sandbox/"
//        products
    }
}