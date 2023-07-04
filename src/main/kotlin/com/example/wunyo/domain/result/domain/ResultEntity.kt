package com.example.wunyo.domain.result.domain

import com.example.wunyo.domain.hobby.domain.HobbyEntity
import com.example.wunyo.domain.user.domain.UserEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import jakarta.validation.constraints.NotNull
import java.time.LocalDateTime

@Table(name = "tbl_result")
@Entity
class ResultEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    val content: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    val user: UserEntity,

    @field:NotNull
    val createdDate: LocalDateTime = LocalDateTime.now(),

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hobby_id", nullable = false)
    val hobby: HobbyEntity,
)
