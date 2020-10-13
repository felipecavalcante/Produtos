package com.example.challangegok.feature.home.data.repository

import com.example.challangegok.feature.home.data.service.ApiService
import com.example.challangegok.feature.home.data.service.RequestResponse
import io.reactivex.Single
import javax.inject.Inject

interface ApiRepository {
    fun requestInfo(): Single<RequestResponse?>

    class Impl @Inject constructor(
        private val service: ApiService
    ): ApiRepository{
        override fun requestInfo(): Single<RequestResponse?> =
            service.requestInformation()
    }
}