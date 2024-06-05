package com.devrachit.kotlineary.presentation.Screens.ItemDetailsScreen

import androidx.lifecycle.ViewModel
import com.devrachit.kotlineary.domain.SharedModels.AllRecipe
import com.devrachit.kotlineary.domain.model.AllRecipes
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ItemDetailsViewModel @Inject constructor(
    val allRecipes: AllRecipe
) :ViewModel(){
}