package com.example.challangegok.feature.home.data.service

import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {
    @GET("products")
    fun requestInformation(): Single<RequestResponse?>
}