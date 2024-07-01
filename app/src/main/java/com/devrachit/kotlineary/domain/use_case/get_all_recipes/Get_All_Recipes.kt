package com.devrachit.kotlineary.domain.use_case.get_all_recipes

import com.devrachit.kotlineary.common.Resource
import com.devrachit.kotlineary.data.remote.dto.AllRecipeDto
import com.devrachit.kotlineary.domain.repository.SpoonacularRepository
import com.devrachit.mode_data.data.repository.SpoonacularRepository2
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class Get_All_Recipes @Inject constructor(
    private val repository: SpoonacularRepository2,
) {
    operator fun invoke(apiKey: String): Flow<Resource<com.devrachit.mode_data.data.remote.dto.AllRecipeDto>> = flow{
        try{
            emit(Resource.Loading())
            val response = repository.getAllRecipes(apiKey)
            if(response.number == 0) {
                emit(Resource.Error("No recipes found"))
            }
            else{
                emit(Resource.Success(response))
            }

        }catch(e: Exception){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        }
    }

}