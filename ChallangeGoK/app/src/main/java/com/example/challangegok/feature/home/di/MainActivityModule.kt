package com.example.challangegok.feature.home.di

import androidx.lifecycle.ViewModel
import com.example.challangegok.base.annotation.ActivityScope
import com.example.challangegok.base.annotation.ViewModelKey
import com.example.challangegok.feature.home.presentation.MainActivityViewModel
import com.example.challangegok.feature.home.data.repository.ApiRepository
import com.example.challangegok.feature.home.data.service.ApiService
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Named

@Module
class MainActivityModule {

    @Provides
    @ActivityScope
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    fun provideViewModel(viewModel: MainActivityViewModel): ViewModel = viewModel

    @Provides
    @ActivityScope
    fun provideService(retrofit: Retrofit): ApiService = retrofit.create()

    @Provides
    @ActivityScope
    fun provideRepository(repository: ApiRepository.Impl): ApiRepository = repository

    @Named("IO")
    @Provides
    fun provideIO(): Scheduler = Schedulers.io()

    @Named("Main")
    @Provides
    fun provideMain(): Scheduler = AndroidSchedulers.mainThread()

}
