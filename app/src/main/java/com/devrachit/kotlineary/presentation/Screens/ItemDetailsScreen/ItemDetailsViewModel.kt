package com.devrachit.kotlineary.presentation.Screens.ItemDetailsScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devrachit.kotlineary.common.Constants.API_KEY
import com.devrachit.kotlineary.common.Resource
import com.devrachit.kotlineary.data.remote.dto.ItemModelDto
import com.devrachit.kotlineary.data.remote.dto.RecipeDto
import com.devrachit.kotlineary.domain.SharedModels.AllRecipe
import com.devrachit.kotlineary.domain.model.AllRecipes
import com.devrachit.kotlineary.domain.use_case.get_recipe.Get_Recipe
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ItemDetailsViewModel @Inject constructor(
    val allRecipes: AllRecipe,
    val getRecipe: Get_Recipe
) :ViewModel(){
    val _loading = MutableStateFlow(false)
    val loading = _loading.asStateFlow()

    val _recipe = MutableStateFlow<ItemModelDto?>(null)
    val recipe = _recipe.asStateFlow()
    fun getRecipe(id : Int)
    {
        getRecipe(id, apiKey = API_KEY).onEach{result->
            when(result)
            {
                is Resource.Success -> {
                    _recipe.value = result.data
                    println(result.data)
                    _loading.value = false
                }
                is Resource.Error -> {
                    _loading.value = false
                }
                is Resource.Loading -> {
                    _loading.value = true
                }
            }
        }.launchIn(viewModelScope)
    }
}