package com.devrachit.kotlineary.presentation.Screens.FavoriteScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devrachit.kotlineary.data.remote.dto.ItemModelDto
import com.devrachit.kotlineary.domain.SharedModels.AllRecipe
import com.devrachit.kotlineary.domain.model.Recipe
import com.devrachit.kotlineary.room.FavoriteRecipe
import com.devrachit.kotlineary.room.FavoriteRecipeDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteScreenViewModel @Inject constructor(
    private val favoriteRecipeDao: FavoriteRecipeDao,
    val allRecipes: AllRecipe,
):ViewModel() {
    val _loading = MutableStateFlow(false)
    val loading = _loading.asStateFlow()

    val _recipe = MutableStateFlow<ItemModelDto?>(null)
    val recipe = _recipe.asStateFlow()

    val _recipeFetch = MutableStateFlow(false)
    val recipeFetch= _recipeFetch.asStateFlow()

    val _favoriteRecipes = MutableStateFlow<List<FavoriteRecipe>>(emptyList())
    val favoriteRecipes = _favoriteRecipes.asStateFlow()
    fun saveRecipeToFavorites(recipe: Recipe) {
        viewModelScope.launch {
            val favoriteRecipe = FavoriteRecipe(
                id = recipe.id,
                title = recipe.title,
                image = recipe.image,
                readyInMinutes = recipe.readyInMinutes,
                servings = recipe.servings,
                pricePerServing = recipe.pricePerServing,
                instructions = recipe.instructions,
                summary = recipe.summary
            )
            favoriteRecipeDao.insertFavorite(favoriteRecipe)
            println("Recipe saved to favorites")
        }
    }
    fun removeRecipeFromFavorites(recipeId: Int) {
        viewModelScope.launch {
            favoriteRecipeDao.deleteFavorite(recipeId)
        }
    }

    fun isRecipeFavorite(recipeId: Int, onResult: (Boolean) -> Unit) {
        viewModelScope.launch {
            val recipe = favoriteRecipeDao.getFavorite(recipeId)
            onResult(recipe != null)
        }
    }
    fun getFavoriteRecipe(recipeId: Int, onResult: (FavoriteRecipe?) -> Unit) {
        viewModelScope.launch {
            val recipe = favoriteRecipeDao.getFavorite(recipeId)
            onResult(recipe)
            println(recipe)
        }
    }

    fun getFavoriteRecipes() {
        viewModelScope.launch {
            val recipes = favoriteRecipeDao.getAllFavorites()
            _favoriteRecipes.value = recipes
            _recipeFetch.value = true
        }
    }
}