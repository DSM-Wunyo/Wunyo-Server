package com.example.wunyo.domain.hobby.presentation.dto.response

data class QueryHobbyRankingList(
    val rankingList: List<HobbyRankingElement>,
) {
    data class HobbyRankingElement(
        val hobby: String,
        val ratio: Double,
    )
}
