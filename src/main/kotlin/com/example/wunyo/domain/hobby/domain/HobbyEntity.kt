package com.example.wunyo.domain.hobby.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Table(name = "tbl_hobby")
@Entity
class HobbyEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    val name: String,
)
