package com.example.wunyo.domain.hobby.service

import com.example.wunyo.domain.hobby.domain.HobbyRepository
import com.example.wunyo.domain.hobby.presentation.dto.response.QueryHobbyRankingList
import com.example.wunyo.domain.hobby.presentation.dto.response.QueryHobbyRankingList.HobbyRankingElement
import org.springframework.stereotype.Service

@Service
class QueryHobbyRankingService(
    private val hobbyRepository: HobbyRepository,
) {

    fun getHobbyRankingList(): QueryHobbyRankingList {
        val hobbyAllCount = hobbyRepository.findAll().count().toDouble()
        val hobbyCountMap = hobbyRepository.countHobby() // key : 취미 이름, value : 취미 수

        val response = hobbyCountMap.map {
            HobbyRankingElement(
                hobby = it.key,
                ratio = it.value.toDouble() / hobbyAllCount * 100 // 비율 구하기
            )
        }

        return QueryHobbyRankingList(response.sortedByDescending { it.ratio })
    }
}
