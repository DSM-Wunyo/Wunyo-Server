package com.example.wunyo.domain.result.service

import com.example.wunyo.domain.hobby.domain.HobbyRepository
import com.example.wunyo.domain.result.domain.ResultEntity
import com.example.wunyo.domain.result.domain.ResultRepository
import com.example.wunyo.domain.result.presentation.dto.response.QueryResultList
import com.example.wunyo.domain.result.presentation.dto.response.QueryResultList.ResultElement
import com.example.wunyo.domain.result.presentation.dto.response.QueryResultResponse
import com.example.wunyo.domain.result.presentation.dto.response.SaveResultRequest
import com.example.wunyo.domain.user.domain.UserRepository
import com.example.wunyo.domain.user.domain.type.Sex
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class ResultService(
    private val userRepository: UserRepository,
    private val resultRepository: ResultRepository,
    private val hobbyRepository: HobbyRepository,
) {

    fun getResultList(name: String, sex: Sex, birthday: LocalDate): QueryResultList {
        val result = resultRepository.findAllResultByNameAndSexAndBirthday(name, sex, birthday)

        val response = result.map {
            ResultElement(
                hobby = it.hobby.name,
                resultDate = it.createdDate,
            )
        }

        return QueryResultList(response)
    }

    fun saveResult(request: SaveResultRequest): Int {
        val user = userRepository.findByName(request.name)

        val ceilAge = when (LocalDate.now().dayOfYear - request.birthday.dayOfYear + 1) { // user age 평균 내기
            in 0..29 -> 20
            in 30..49 -> 40
            in 50..100 -> 50
            else -> 10
        }

        val hobby = when {
            request.activeScore >= 36 && request.soloScore >= 36 -> {
                hobbyRepository.findHobby(
                    hobbyAge = ceilAge,
                    isActive = true,
                    isSolo = true,
                )
            }

            request.activeScore < 36 && request.soloScore >= 36 -> {
                hobbyRepository.findHobby(
                    hobbyAge = ceilAge,
                    isActive = false,
                    isSolo = true,
                )
            }

            request.activeScore >= 36 && request.soloScore < 36 -> {
                hobbyRepository.findHobby(
                    hobbyAge = ceilAge,
                    isActive = true,
                    isSolo = false,
                )
            }

            else -> {
                hobbyRepository.findHobby(
                    hobbyAge = ceilAge,
                    isActive = false,
                    isSolo = false,
                )
            }
        }

        val result = resultRepository.save(
            ResultEntity(
                user = user,
                hobby = hobby,
            )
        )

        return result.id
    }

    fun getOneResult(resultId: Int): QueryResultResponse {
        val result = resultRepository.findByIdOrNull(resultId)
            ?: throw IllegalArgumentException("error")

        return QueryResultResponse(
            recommendHobby = result.hobby.name,
            content = result.hobby.content,
        )
    }
}
