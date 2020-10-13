package com.example.challangegok.feature.details.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.challangegok.feature.home.model.GenericModel
import javax.inject.Inject

class DetailsActivityViewModel @Inject constructor(
    private val details: GenericModel
): ViewModel(){
    val serviceDetails = MutableLiveData<GenericModel>().apply { value = details }
}