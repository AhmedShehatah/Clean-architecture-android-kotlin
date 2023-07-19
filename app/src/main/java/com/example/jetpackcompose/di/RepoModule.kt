package com.example.jetpackcompose.di

import com.shehatah.data.remote.APIService
import com.shehatah.data.repo.MealsRepoImpl
import com.shehatah.domain.repo.MealsRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    fun provideMealsRepo(apiService: APIService): MealsRepo {
        return MealsRepoImpl(apiService)
    }
}