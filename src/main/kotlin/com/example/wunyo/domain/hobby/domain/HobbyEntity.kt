package com.example.wunyo.domain.hobby.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.validation.constraints.NotNull

@Table(name = "tbl_hobby")
@Entity
class HobbyEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    val name: String,

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    val content: String,

    @field:NotNull
    val active: Boolean,

    @field:NotNull
    val solo: Boolean,

    @Column(columnDefinition = "INT", nullable = false)
    val hobbyAge: Int,
)
