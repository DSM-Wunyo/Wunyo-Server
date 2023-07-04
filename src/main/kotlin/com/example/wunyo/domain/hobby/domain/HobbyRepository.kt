package com.example.wunyo.domain.hobby.domain

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface HobbyRepository : CrudRepository<HobbyEntity, Int> {

    fun findByHobbyAgeAndActiveAndSolo(hobbyAge: Int, isActive: Boolean, isSolo: Boolean): HobbyEntity
}
