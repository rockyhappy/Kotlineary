package com.devrachit.kotlineary.presentation.Screens.HomeScreen

import androidx.lifecycle.ViewModel
import com.devrachit.kotlineary.domain.repository.SpoonacularRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val repository: SpoonacularRepository
) : ViewModel(){
}