package com.example.wunyo.domain.result.presentation.dto.response

import com.example.wunyo.domain.user.domain.type.Sex
import java.time.LocalDate

data class SaveResultRequest(
    val name: String,
    val sex: Sex,
    val birthday: LocalDate,
    val activeScore: Int,
    val soloScore: Int,
)
