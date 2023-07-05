package com.example.wunyo.domain.hobby.domain

interface CustomHobbyRepository {
    fun findByHobbyAgeAndActiveAndSolo(hobbyAge: Int, isActive: Boolean, isSolo: Boolean): HobbyEntity
}
