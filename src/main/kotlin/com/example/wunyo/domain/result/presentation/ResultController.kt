package com.example.wunyo.domain.result.presentation

import com.example.wunyo.domain.result.service.ResultService
import com.example.wunyo.domain.user.domain.type.Sex
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RequestMapping("/result")
@RestController
class ResultController(
    private val resultService: ResultService,
) {

    @GetMapping("/list")
    fun getResultList(
        @RequestParam name: String,
        @RequestParam sex: Sex,
        @RequestParam birthday: LocalDate,
    ) = resultService.getResultList(name, sex, birthday)
}
