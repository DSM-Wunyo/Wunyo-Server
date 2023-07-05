package com.example.wunyo.domain.hobby.domain

interface CustomHobbyRepository {
    fun findHobby(hobbyAge: Int, isActive: Boolean, isSolo: Boolean): HobbyEntity
    fun countHobby(): Map<String, Int>
}
