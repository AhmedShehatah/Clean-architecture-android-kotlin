package com.shehatah.domain.repo

import com.shehatah.domain.models.CategoryResponse

interface MealsRepo {

    suspend fun getMealsFromRemote(): CategoryResponse
}