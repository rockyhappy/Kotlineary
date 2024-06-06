package com.devrachit.kotlineary.domain.use_case.get_recipe

import com.devrachit.kotlineary.common.Resource
import com.devrachit.kotlineary.data.remote.dto.ItemModelDto
import com.devrachit.kotlineary.domain.repository.SpoonacularRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class Get_Recipe @Inject constructor(
    private val repository: SpoonacularRepository,
){
    operator fun invoke(id: Int, apiKey: String) : Flow<Resource<ItemModelDto>> = flow{
        try {
            emit(Resource.Loading())
            val response = repository.getRecipe(id, apiKey)

            println( response )
            if(response.id == 0){
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