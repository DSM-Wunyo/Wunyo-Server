package com.example.wunyo.domain.user.domain

import com.example.wunyo.domain.user.domain.type.Sex
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDate

@Table(name = "tbl_user")
@Entity
class UserEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    @Column(columnDefinition = "VARCHAR(10)", nullable = false)
    val name: String,

    @Column(columnDefinition = "VARCHAR(6)", nullable = false)
    @Enumerated(EnumType.STRING)
    val sex: Sex,

    @Column(columnDefinition = "VARCHAR(20)", nullable = false)
    val birthday: LocalDate,
)
