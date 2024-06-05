package com.devrachit.kotlineary.data.remote.dto

import com.devrachit.kotlineary.domain.model.Result

data class ResultDto(
    val id: Int,
    val image: String,
    val imageType: String,
    val title: String
)

fun ResultDto.toRecipeDto() = Result(
    id = id,
    image = image,
    imageType = imageType,
    title = title
)