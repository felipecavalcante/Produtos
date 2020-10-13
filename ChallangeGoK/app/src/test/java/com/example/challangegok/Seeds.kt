package com.example.challangegok

import com.example.challangegok.feature.home.data.service.Cash
import com.example.challangegok.feature.home.data.service.Products
import com.example.challangegok.feature.home.data.service.RequestResponse
import com.example.challangegok.feature.home.data.service.Spotlight
import com.example.challangegok.feature.home.model.GenericModel

object Seeds {
    private const val NAME = "generic name"
    private const val URL = "generic url"
    private const val DESCRIPTION = "generic description"

    val genericModel = GenericModel(
        name = NAME,
        imageUrl = URL,
        description = DESCRIPTION
    )
    private val spotlightMock = Spotlight(
        name = NAME,
        bannerURL = URL,
        description = DESCRIPTION
    )

    private val productsMock = Products(
        name = NAME,
        imageURL = URL,
        description = DESCRIPTION
    )

    private val cashMock = Cash(
        title = NAME,
        bannerURL = URL,
        description = DESCRIPTION
    )

    val repositoryMockResponse = RequestResponse(
        spotlight = listOf(spotlightMock),
        products = listOf(productsMock),
        cash = cashMock
    )
}