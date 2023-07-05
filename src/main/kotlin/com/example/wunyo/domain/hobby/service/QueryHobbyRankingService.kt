package com.example.wunyo.domain.hobby.service

import com.example.wunyo.domain.hobby.domain.HobbyRepository
import com.example.wunyo.domain.hobby.presentation.dto.response.QueryHobbyRankingList
import com.example.wunyo.domain.hobby.presentation.dto.response.QueryHobbyRankingList.HobbyRankingElement
import com.example.wunyo.domain.result.domain.ResultRepository
import org.springframework.stereotype.Service

@Service
class QueryHobbyRankingService(
    private val hobbyRepository: HobbyRepository,
    private val resultRepository: ResultRepository,
) {

    fun getHobbyRankingList(): QueryHobbyRankingList {
        val hobbyAllCount = resultRepository.findAll().count()
        val hobbyCountMap = hobbyRepository.countHobby() // key : 취미 이름, value : 취미 수

        val response = hobbyCountMap.map {
            HobbyRankingElement(
                hobbyId = it.key.toInt(),
                hobby = it.value.first,
                ratio = it.value.second.toDouble() / hobbyAllCount * 100 // 비율 구하기
            )
        }

        return QueryHobbyRankingList(response.sortedByDescending { it.ratio })
    }
}
