package com.devrachit.kotlineary.presentation.Screens.HomeScreen

import androidx.lifecycle.ViewModel
import com.devrachit.kotlineary.domain.repository.SpoonacularRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val repository: SpoonacularRepository
) : ViewModel(){
    private val _searchQuery = MutableStateFlow("")
    val searchQuery = _searchQuery.asStateFlow()
    fun setSearchQuery(query: String) {
        _searchQuery.value = query

    }
    fun getSearchQuery() = searchQuery.value
}