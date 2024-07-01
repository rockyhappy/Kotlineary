package com.devrachit.mode_data.data.remote

import com.devrachit.mode_data.data.Constants
import com.devrachit.mode_data.data.remote.dto.AllRecipeDto
import com.devrachit.mode_data.data.remote.dto.ItemModelDto
import com.devrachit.mode_data.data.remote.dto.recipieModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface spoonacularApi2 {
    @GET("recipes/random")
    suspend fun getRandomRecipe(
        @Query("number") number: Int,
        @Query("apiKey") apiKey: String = Constants.API_KEY,
    ): recipieModel

    @GET("/recipes/complexSearch")
    suspend fun getAllRecipes(
        @Query("apiKey") apiKey: String = Constants.API_KEY,
    ): AllRecipeDto

    @GET("/recipes/{id}/information")
    suspend fun getRecipe(
        @Path("id") id: Int,
        @Query("apiKey") apiKey: String = Constants.API_KEY,
    ): ItemModelDto

    @GET("/recipes/complexSearch")
    suspend fun searchRecipe(
        @Query("query") query: String,
        @Query("apiKey") apiKey: String = Constants.API_KEY,
    ): AllRecipeDto

}