package com.example.wunyo.domain.result.domain

import com.example.wunyo.domain.user.domain.type.Sex
import java.time.LocalDate

interface CustomResultRepository {
    fun findAllResultByNameAndSexAndBirthday(name: String, sex: Sex, birthday: LocalDate): List<ResultEntity>
}
