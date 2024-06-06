package com.devrachit.kotlineary.data.repository

import com.devrachit.kotlineary.data.remote.dto.AllRecipeDto
import com.devrachit.kotlineary.data.remote.dto.ItemModelDto
import com.devrachit.kotlineary.data.remote.dto.RecipeDto
import com.devrachit.kotlineary.data.remote.dto.recipieModel
import com.devrachit.kotlineary.data.remote.spoonacularApi
import com.devrachit.kotlineary.domain.repository.SpoonacularRepository
import retrofit2.Response
import javax.inject.Inject

class SpoonacularRepositoryImpl @Inject constructor(
    private val api: spoonacularApi
) : SpoonacularRepository {
    override suspend fun getRandomRecipe(number: Int, apiKey: String): recipieModel
    {
        return api.getRandomRecipe(number, apiKey)
    }
    override suspend fun getAllRecipes(apiKey: String): AllRecipeDto
    {
        return api.getAllRecipes(apiKey)
    }
    override suspend fun getRecipe(id: Int, apiKey: String): ItemModelDto
    {
        return api.getRecipe(id, apiKey)
    }

    override suspend fun searchRecipe(query: String, apiKey: String): AllRecipeDto
    {
        return api.searchRecipe(query, apiKey)
    }
}