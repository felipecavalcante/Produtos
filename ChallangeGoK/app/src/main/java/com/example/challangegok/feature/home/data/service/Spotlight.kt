package com.example.challangegok.feature.home.data.service

import com.example.challangegok.feature.home.model.GenericModel

data class Spotlight(
    val name: String,
    val bannerURL: String,
    val description: String
) {
    fun toGeneticModel(): GenericModel = GenericModel(
        name = name,
        imageUrl = bannerURL,
        description = description
    )
}

