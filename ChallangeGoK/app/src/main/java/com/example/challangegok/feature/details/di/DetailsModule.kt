package com.example.challangegok.feature.details.di

import com.example.challangegok.base.annotation.ActivityScope
import com.example.challangegok.feature.details.presentation.DetailsActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class DetailsModule{

    @ActivityScope
    @ContributesAndroidInjector(modules = [DetailsActivityModule::class])
    abstract fun contributesDetailsActivity(): DetailsActivity
}