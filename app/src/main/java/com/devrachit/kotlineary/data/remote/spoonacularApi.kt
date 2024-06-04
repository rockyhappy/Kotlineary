package com.devrachit.kotlineary.data.remote

import com.devrachit.kotlineary.data.remote.dto.RecipeDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface spoonacularApi {
    @GET("random")
    suspend fun getRandomRecipe(
        @Query("number") number: Int,
        @Query("apiKey") apiKey: String
    ): RecipeDto
}