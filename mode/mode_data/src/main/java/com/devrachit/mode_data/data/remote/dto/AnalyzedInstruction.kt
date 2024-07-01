package com.devrachit.mode_data.data.remote.dto



data class AnalyzedInstruction(
    val name: String,
    val steps: List<Step>
)