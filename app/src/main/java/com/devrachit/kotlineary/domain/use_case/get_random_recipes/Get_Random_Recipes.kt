package com.devrachit.kotlineary.domain.use_case.get_random_recipes

import com.devrachit.kotlineary.common.Resource
import com.devrachit.kotlineary.data.remote.dto.RecipeDto
import com.devrachit.kotlineary.data.remote.dto.recipieModel
import com.devrachit.kotlineary.data.remote.dto.toRecipe
import com.devrachit.kotlineary.domain.model.Recipe
import com.devrachit.kotlineary.domain.repository.SpoonacularRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class Get_Random_Recipes @Inject constructor(
    private val repository: SpoonacularRepository,
){
    operator fun invoke(number: Int, apiKey: String): Flow<Resource<recipieModel>> = flow{
        try {
            emit(Resource.Loading())
            val response = repository.getRandomRecipe(number, apiKey)

            println( response )
            if(response.recipes.isEmpty()){
                emit(Resource.Error("No recipes found"))
            }
            else{
                emit(Resource.Success(response))
            }
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        }
    }
}