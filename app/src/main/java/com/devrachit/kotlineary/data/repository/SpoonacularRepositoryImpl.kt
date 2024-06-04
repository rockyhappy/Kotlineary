package com.devrachit.kotlineary.data.repository

import com.devrachit.kotlineary.data.remote.dto.RecipeDto
import com.devrachit.kotlineary.data.remote.spoonacularApi
import com.devrachit.kotlineary.domain.repository.SpoonacularRepository
import javax.inject.Inject

class SpoonacularRepositoryImpl @Inject constructor(
    private val api: spoonacularApi
) : SpoonacularRepository {
    override suspend fun getRandomRecipe(number: Int, apiKey: String): RecipeDto
    {
        return api.getRandomRecipe(number, apiKey)
    }
}