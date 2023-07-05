package com.example.wunyo.domain.hobby.presentation

import com.example.wunyo.domain.hobby.presentation.dto.response.QueryHobbyRankingList
import com.example.wunyo.domain.hobby.service.QueryHobbyRankingService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/hobby")
@RestController
class HobbyController(
    private val queryHobbyRankingService: QueryHobbyRankingService,
) {

    @GetMapping("/ranking")
    fun getHobbyRanking(): QueryHobbyRankingList =
        queryHobbyRankingService.getHobbyRankingList()
}
