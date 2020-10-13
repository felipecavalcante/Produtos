package com.example.challangegok.base.di

import android.app.Application
import com.example.challangegok.base.MyApplication
import com.example.challangegok.feature.details.di.DetailsModule
import com.example.challangegok.feature.home.di.MainModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        MainModule::class,
        DetailsModule::class,
        NetworkingModule::class,
        ViewModelModule::class
    ]
)

interface AppComponent : AndroidInjector<MyApplication> {

    fun inject(app: Application)

    @Component.Builder
    interface Builder {
        fun build(): AppComponent

        @BindsInstance
        fun applicationBind(application: Application): Builder
    }
}