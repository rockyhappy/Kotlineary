package com.devrachit.kotlineary.presentation.Screens.HomeScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devrachit.kotlineary.common.Constants
import com.devrachit.kotlineary.common.Resource
import com.devrachit.kotlineary.data.remote.dto.ItemModelDto
import com.devrachit.kotlineary.data.remote.dto.recipieModel
import com.devrachit.kotlineary.domain.SharedModels.AllRecipe
import com.devrachit.kotlineary.domain.SharedModels.PopularRecipe
import com.devrachit.kotlineary.domain.repository.SpoonacularRepository
import com.devrachit.kotlineary.domain.use_case.get_all_recipes.Get_All_Recipes
import com.devrachit.kotlineary.domain.use_case.get_random_recipes.Get_Random_Recipes
import com.devrachit.kotlineary.domain.use_case.get_recipe.Get_Recipe
import com.devrachit.kotlineary.domain.use_case.get_search_recipe.Get_search_recipe
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val repository: SpoonacularRepository,
    private val getRandomRecipes: Get_Random_Recipes,
    private val getAllRecipes: Get_All_Recipes,
    private val getSearchRecipe: Get_search_recipe,
    val sharedModel : PopularRecipe,
    val allRecipeModel : AllRecipe,
    val getRecipe: Get_Recipe
) : ViewModel(){
    private val _searchQuery = MutableStateFlow("")
    val searchQuery = _searchQuery.asStateFlow()

    fun setSearchQuery(query: String) {
        _searchQuery.value = query

    }
    fun getSearchQuery() = searchQuery.value

    val _loading = MutableStateFlow(false)
    val loading = _loading.asStateFlow()

    init {
        handleSearchQuery()
    }
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
    private fun handleSearchQuery() {
        _searchQuery
            .debounce(1000) // 1-second delay
            .distinctUntilChanged()
            .onEach { query ->
                if (query.isNotEmpty()) {
                    getQueryRecipes(query)
                }
            }
            .launchIn(viewModelScope)
    }
    fun getQueryRecipes(query:String){
        getSearchRecipe(query=query,Constants.API_KEY).onEach { result->
            println(result)
            when (result) {
                is Resource.Success -> {
                    println("Success")
                    allRecipeModel.setSearchRecipe(result)
                    _loading.value = false

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

    val _searchItemDetails = MutableStateFlow<ItemModelDto?>(null)
    val searchItemDetails = _searchItemDetails.asStateFlow()
    fun getRecipe(id : Int)
    {
        getRecipe(id, apiKey = Constants.API_KEY).onEach{ result->
            when(result)
            {
                is Resource.Success -> {
                    _searchItemDetails.value = result.data
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