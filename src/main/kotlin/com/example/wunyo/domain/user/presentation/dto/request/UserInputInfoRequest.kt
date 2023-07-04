package com.example.wunyo.domain.user.presentation.dto.request

import com.example.wunyo.domain.user.domain.type.Sex
import java.time.LocalDate

data class UserInputInfoRequest(
    val name: String,
    val sex: Sex,
    val birthday: LocalDate,
)
