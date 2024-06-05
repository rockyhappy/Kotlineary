package com.devrachit.kotlineary.domain.repository

import com.devrachit.kotlineary.data.remote.dto.RecipeDto
import com.devrachit.kotlineary.data.remote.dto.recipieModel

interface SpoonacularRepository {
    suspend fun getRandomRecipe(number: Int, apiKey: String) : recipieModel
}