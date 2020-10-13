package com.example.challangegok.feature.home.data.service

import com.example.challangegok.feature.home.model.GenericModel

data class Products(
    val name: String,
    val imageURL: String,
    val description: String
) {
    fun toGenericModel(): GenericModel = GenericModel(
        name = name,
        imageUrl = imageURL,
        description = description
    )
}