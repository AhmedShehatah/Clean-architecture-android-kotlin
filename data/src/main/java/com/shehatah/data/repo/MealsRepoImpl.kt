package com.shehatah.data.repo

import com.shehatah.data.remote.APIService
import com.shehatah.domain.models.CategoryResponse
import com.shehatah.domain.repo.MealsRepo

class MealsRepoImpl(private val apiService: APIService) : MealsRepo {
    override suspend fun getMealsFromRemote(): CategoryResponse = apiService.getMeals()
}