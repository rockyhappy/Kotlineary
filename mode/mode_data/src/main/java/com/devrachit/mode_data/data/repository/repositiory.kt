package com.devrachit.mode_data.data.repository

import com.devrachit.mode_data.data.remote.dto.AllRecipeDto
import com.devrachit.mode_data.data.remote.dto.ItemModelDto
import com.devrachit.mode_data.data.remote.dto.recipieModel

interface SpoonacularRepository2 {
    suspend fun getRandomRecipe(number: Int, apiKey: String) : recipieModel

    suspend fun getAllRecipes(apiKey: String) : AllRecipeDto

    suspend fun getRecipe(id: Int, apiKey: String) : ItemModelDto

    suspend fun searchRecipe(query: String, apiKey: String) : AllRecipeDto
}