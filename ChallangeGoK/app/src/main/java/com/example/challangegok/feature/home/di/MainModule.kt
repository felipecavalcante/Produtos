package com.example.challangegok.feature.home.di

import com.example.challangegok.base.annotation.ActivityScope
import com.example.challangegok.feature.home.presentation.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun contributesMainActivity(): MainActivity

}