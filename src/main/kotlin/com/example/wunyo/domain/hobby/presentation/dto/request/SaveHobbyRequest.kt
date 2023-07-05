package com.example.wunyo.domain.hobby.presentation.dto.request

data class SaveHobbyRequest(
    val content: String,
    val hobbyAge: Int,
    val active: Boolean,
    val solo: Boolean,
    val name: String,
)
