package com.example.jetpackcompose.di

import com.shehatah.domain.repo.MealsRepo
import com.shehatah.domain.usecases.GetMeals
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideGetMealsUseCase(repo: MealsRepo): GetMeals {
        return GetMeals(repo)
    }
}