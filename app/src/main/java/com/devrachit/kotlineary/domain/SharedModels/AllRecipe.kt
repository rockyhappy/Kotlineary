package com.devrachit.kotlineary.domain.SharedModels

import com.devrachit.kotlineary.common.Resource
import com.devrachit.kotlineary.data.remote.dto.AllRecipeDto
import com.devrachit.kotlineary.data.remote.dto.recipieModel
import com.devrachit.kotlineary.room.FavoriteRecipe
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AllRecipe @Inject constructor() {

    private val _recipes = MutableStateFlow<Resource<AllRecipeDto>?>(null)
    val recipes = _recipes.asStateFlow()

    fun setRecipes(recipe: Resource<AllRecipeDto>){
        _recipes.value = recipe
    }
    fun getRecipes() = recipes.value

    private val _id = MutableStateFlow(0)
    val id = _id.asStateFlow()

    fun setId(id: Int){
        _id.value = id
    }
    fun getId() = id.value

    private val _searchRecipe = MutableStateFlow<Resource<AllRecipeDto>?>(null)
    val searchRecipe = _searchRecipe.asStateFlow()

    fun setSearchRecipe(recipe: Resource<AllRecipeDto>){
        _searchRecipe.value = recipe
    }

    fun getSearchRecipe() = searchRecipe.value


    val _favoriteRecipe = MutableStateFlow<FavoriteRecipe?>(null)
    val favoriteRecipe = _favoriteRecipe.asStateFlow()

    fun setFavoriteRecipe(recipe: FavoriteRecipe){
        _favoriteRecipe.value = recipe
    }
    fun getFavoriteRecipe() = favoriteRecipe.value
}