package com.devrachit.mode_data.data.remote.dto

data class EquipmentX(
    val id: Int,
    val image: String,
    val localizedName: String,
    val name: String,
    val temperature: TemperatureX
)