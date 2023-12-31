package com.example.wunyo.domain.user.domain

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<UserEntity, Int> {

    fun findByName(name: String): UserEntity
    fun existsByName(name: String): Boolean
}
