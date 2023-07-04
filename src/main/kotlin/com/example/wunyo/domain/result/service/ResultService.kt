package com.example.wunyo.domain.result.service

import com.example.wunyo.domain.result.domain.ResultRepository
import com.example.wunyo.domain.result.presentation.dto.response.QueryResultList
import com.example.wunyo.domain.result.presentation.dto.response.QueryResultList.ResultElement
import com.example.wunyo.domain.user.domain.type.Sex
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class ResultService(
    private val resultRepository: ResultRepository,
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
}
