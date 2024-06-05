package com.devrachit.kotlineary.data.remote.dto

import com.devrachit.kotlineary.domain.model.AllRecipes

data class AllRecipeDto(
    val number: Int,
    val offset: Int,
    val results: List<ResultDto>,
    val totalResults: Int
)

fun AllRecipeDto.toAllRecipes() = AllRecipes(
    number = number,
    offset = offset,
    results = results.map { it.toRecipeDto() },
    totalResults = totalResults
)



