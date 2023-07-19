package com.shehatah.domain.usecases

import com.shehatah.domain.repo.MealsRepo

class GetMeals(private val repo: MealsRepo) {
    suspend operator fun invoke() = repo.getMealsFromRemote()
}