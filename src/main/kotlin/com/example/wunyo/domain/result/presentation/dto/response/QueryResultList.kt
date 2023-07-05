package com.example.wunyo.domain.result.presentation.dto.response

import java.time.LocalDate
import java.time.LocalDateTime

data class QueryResultList(
    val resultList: List<ResultElement>,
) {
    data class ResultElement(
        val hobbyId: Int,
        val hobby: String,
        val resultDate: LocalDateTime,
    )
}
