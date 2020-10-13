package com.example.challangegok.feature.home.data.service

import com.example.challangegok.feature.home.model.GenericModel

data class Cash(
    val title: String,
    val bannerURL: String,
    val description: String
) {
    fun toGenericModel(): GenericModel = GenericModel(
        name = title,
        imageUrl = bannerURL,
        description = description
    )

}