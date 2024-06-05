package com.devrachit.kotlineary.presentation.Screens.LoginScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devrachit.kotlineary.common.Constants.API_KEY
import com.devrachit.kotlineary.common.Resource
import com.devrachit.kotlineary.domain.repository.SpoonacularRepository
import com.devrachit.kotlineary.domain.use_case.get_random_recipes.Get_Random_Recipes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginScreenViewModel @Inject constructor(
    private val repository: SpoonacularRepository,
    private val getRandomRecipes: Get_Random_Recipes
): ViewModel(){
    init {
        println("LoginScreenViewModel")
    }
    fun getRecipe(){
            getRandomRecipes(1, API_KEY).onEach {result->
                println(result)
                when (result) {
                    is Resource.Success -> {
                        println("Success")
                    }
                    is Resource.Error -> {
                        println("Error")
                    }
                    is Resource.Loading -> {
                        println("Loading")
                    }
                }
            }.launchIn(viewModelScope)

        viewModelScope.launch(Dispatchers.IO) {
            println("getRecipe")
            val response = repository.getRandomRecipe(1, API_KEY)
            println(response)
        }


    }
}