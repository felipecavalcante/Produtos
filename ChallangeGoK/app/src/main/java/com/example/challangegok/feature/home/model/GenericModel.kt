package com.example.challangegok.feature.home.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GenericModel (
    val name: String,
    val imageUrl: String,
    val description: String
): Parcelable