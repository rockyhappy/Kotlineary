package com.devrachit.kotlineary.presentation.Screens.HomeScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devrachit.kotlineary.common.Constants
import com.devrachit.kotlineary.common.Resource
import com.devrachit.kotlineary.data.remote.dto.recipieModel
import com.devrachit.kotlineary.domain.SharedModels.AllRecipe
import com.devrachit.kotlineary.domain.SharedModels.PopularRecipe
import com.devrachit.kotlineary.domain.repository.SpoonacularRepository
import com.devrachit.kotlineary.domain.use_case.get_all_recipes.Get_All_Recipes
import com.devrachit.kotlineary.domain.use_case.get_random_recipes.Get_Random_Recipes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val repository: SpoonacularRepository,
    private val getRandomRecipes: Get_Random_Recipes,
    private val getAllRecipes: Get_All_Recipes,
    val sharedModel : PopularRecipe,
    val allRecipeModel : AllRecipe
) : ViewModel(){
    private val _searchQuery = MutableStateFlow("")
    val searchQuery = _searchQuery.asStateFlow()
    fun setSearchQuery(query: String) {
        _searchQuery.value = query

    }
    fun getSearchQuery() = searchQuery.value

    val _loading = MutableStateFlow(false)
    val loading = _loading.asStateFlow()

    fun getRecipe(){
        getRandomRecipes(8, Constants.API_KEY).onEach { result->
            println(result)
            when (result) {
                is Resource.Success -> {
                    println("Success")
                    _loading.value = false
                    sharedModel.setRecipes(result)
                }
                is Resource.Error -> {
                    println("Error")
                    _loading.value = false

                }
                is Resource.Loading -> {
                    println("Loading")
                    _loading.value = true
                }
            }
        }.launchIn(viewModelScope)
    }
    fun getAllRecipes(){
        getAllRecipes(Constants.API_KEY).onEach { result->
            println(result)
            when (result) {
                is Resource.Success -> {
                    println("Success")
                    _loading.value = false
                    allRecipeModel.setRecipes(result)
                }
                is Resource.Error -> {
                    println("Error")
                    _loading.value = false

                }
                is Resource.Loading -> {
                    println("Loading")
                    _loading.value = true
                }
            }
        }.launchIn(viewModelScope)
    }
}