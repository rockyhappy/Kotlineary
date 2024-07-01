
package com.devrachit.mode_data.data.remote.dto

data class AllRecipeDto(
    val number: Int,
    val offset: Int,
    val results: List<ResultDto>,
    val totalResults: Int
)

fun AllRecipeDto.toAllRecipes() = AllRecipes(
    number = number,
    offset = offset,
    results = results.map { it.toRecipeDto() },
    totalResults = totalResults
)



data class AllRecipes(
    val number: Int,
    val offset: Int,
    val results: List<Result>,
    val totalResults: Int
)

data class Recipe(
    val aggregateLikes : Int,
    val cheap : Boolean,
    val cookingMinutes : Any,
    val creditsText : String,
    val cuisines : List<Any>,
    val dairyFree : Boolean,
    val diets : List<String>,
    val dishTypes : List<String>,
    val gaps : String,
    val glutenFree : Boolean,
    val healthScore : Int,
    val id : Int,
    val image : String,
    val imageType : String,
    val instructions : String,
    val license : String,
    val lowFodmap : Boolean,
    val occasions : List<Any>,
//    val originalId : Any,
    val preparationMinutes : Any,
    val pricePerServing : Double,
    val readyInMinutes : Int,
    val servings : Int,
    val sourceName : String,
    val sourceUrl : String,
    val spoonacularScore : Double,
    val spoonacularSourceUrl : String,
    val summary : String,
    val sustainable : Boolean,
    val title : String,
    val vegan : Boolean,
    val vegetarian : Boolean,
    val veryHealthy : Boolean,
    val veryPopular : Boolean,
    val weightWatcherSmartPoints : Int


)
data class Result(
    val id: Int,
    val image: String,
    val imageType: String,
    val title: String
)
