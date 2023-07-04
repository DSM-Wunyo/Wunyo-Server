package com.example.wunyo.domain.question.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Table(name = "tbl_question")
@Entity
class QuestionEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    val content: String,
)
