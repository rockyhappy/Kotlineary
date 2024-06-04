package com.devrachit.kotlineary.domain.repository

import com.devrachit.kotlineary.data.remote.dto.RecipeDto

interface SpoonacularRepository {
    suspend fun getRandomRecipe(number: Int, apiKey: String) : RecipeDto
}