package com.shehatah.data.remote

import com.shehatah.domain.models.CategoryResponse
import retrofit2.http.GET

interface APIService {

    @GET("categories.php")
    suspend fun getMeals(): CategoryResponse

}