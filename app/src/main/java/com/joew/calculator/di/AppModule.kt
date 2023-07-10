package com.joew.calculator.di

import com.joew.calculator.screens.MainScreenViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMainScreenViewModel(): MainScreenViewModel {
        return MainScreenViewModel()
    }
}