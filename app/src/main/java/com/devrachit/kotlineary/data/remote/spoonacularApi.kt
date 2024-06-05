package com.devrachit.kotlineary.data.remote

import com.devrachit.kotlineary.common.Constants.API_KEY
import com.devrachit.kotlineary.data.remote.dto.AllRecipeDto
import com.devrachit.kotlineary.data.remote.dto.ItemModelDto
import com.devrachit.kotlineary.data.remote.dto.RecipeDto
import com.devrachit.kotlineary.data.remote.dto.recipieModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface spoonacularApi {
    @GET("recipes/random")
    suspend fun getRandomRecipe(
        @Query("number") number: Int,
        @Query("apiKey") apiKey: String = API_KEY,
    ): recipieModel

    @GET("/recipes/complexSearch")
    suspend fun getAllRecipes(
        @Query("apiKey") apiKey: String = API_KEY,
    ): AllRecipeDto

    @GET("/recipes/{id}/information")
    suspend fun getRecipe(
        @Path("id") id: Int,
        @Query("apiKey") apiKey: String = API_KEY,
    ): ItemModelDto

}