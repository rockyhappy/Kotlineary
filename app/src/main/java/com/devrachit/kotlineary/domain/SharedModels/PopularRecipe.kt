package com.devrachit.kotlineary.domain.SharedModels

import com.devrachit.kotlineary.common.Resource
import com.devrachit.kotlineary.data.remote.dto.recipieModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PopularRecipe @Inject constructor() {

    private val _recipes = MutableStateFlow<Resource<recipieModel>?>(null)
    val recipes = _recipes.asStateFlow()

    fun setRecipes(recipe: Resource<recipieModel>){
        _recipes.value = recipe
    }
    fun getRecipes() = recipes.value

}