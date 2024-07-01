package com.devrachit.mode_data.data.remote.dto



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