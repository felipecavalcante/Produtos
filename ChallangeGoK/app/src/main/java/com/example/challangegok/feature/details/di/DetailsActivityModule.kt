package com.example.challangegok.feature.details.di

import androidx.lifecycle.ViewModel
import com.example.challangegok.base.annotation.ActivityScope
import com.example.challangegok.base.annotation.ViewModelKey
import com.example.challangegok.feature.details.presentation.DetailsActivity
import com.example.challangegok.feature.details.presentation.DetailsActivityViewModel
import com.example.challangegok.feature.home.model.GenericModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class DetailsActivityModule {

    @Provides
    @IntoMap
    @ActivityScope
    @ViewModelKey(DetailsActivityViewModel::class)
    fun provideViewModel(viewModel: DetailsActivityViewModel): ViewModel = viewModel

    @Provides
    @ActivityScope
    fun provideBundle(activity: DetailsActivity): GenericModel = activity.bundle
}