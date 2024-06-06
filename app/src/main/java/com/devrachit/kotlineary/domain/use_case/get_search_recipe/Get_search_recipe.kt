package com.devrachit.kotlineary.domain.use_case.get_search_recipe

import com.devrachit.kotlineary.common.Resource
import com.devrachit.kotlineary.data.remote.dto.AllRecipeDto
import com.devrachit.kotlineary.domain.repository.SpoonacularRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class Get_search_recipe @Inject constructor(
    private val repository: SpoonacularRepository
){
    operator fun invoke(query: String, apiKey: String): Flow<Resource<AllRecipeDto>> = flow{
        try {
            emit(Resource.Loading())
            val response = repository.searchRecipe(query, apiKey)

            println( response )
            if(response.results.isEmpty()){
                emit(Resource.Error("No recipe found"))
            }
            else{
                emit(Resource.Success(response))
            }
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        }
    }
}