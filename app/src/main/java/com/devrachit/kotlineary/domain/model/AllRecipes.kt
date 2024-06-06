package com.devrachit.kotlineary.domain.model



data class AllRecipes(
    val number: Int,
    val offset: Int,
    val results: List<Result>,
    val totalResults: Int
)
