package com.example.wunyo.domain.hobby.presentation

import com.example.wunyo.domain.hobby.domain.HobbyEntity
import com.example.wunyo.domain.hobby.domain.HobbyRepository
import com.example.wunyo.domain.hobby.presentation.dto.request.SaveHobbyRequest
import com.example.wunyo.domain.hobby.presentation.dto.response.QueryHobbyRankingList
import com.example.wunyo.domain.hobby.service.QueryHobbyRankingService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/hobby")
@RestController
class HobbyController(
    private val queryHobbyRankingService: QueryHobbyRankingService,
    private val hobbyRepository: HobbyRepository,
) {

    @GetMapping("/ranking")
    fun getHobbyRanking(): QueryHobbyRankingList =
        queryHobbyRankingService.getHobbyRankingList()

    @PostMapping
    fun saveHobby(@RequestBody request: SaveHobbyRequest) {
        hobbyRepository.save(
            HobbyEntity(
                name = request.name,
                content = request.content,
                active = request.active,
                solo = request.solo,
                hobbyAge = request.hobbyAge,
            )
        )
    }
}
