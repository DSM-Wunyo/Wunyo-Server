package com.example.wunyo.domain.question.presentation

import com.example.wunyo.domain.question.presentation.dto.response.QueryAllQuestionList
import com.example.wunyo.domain.question.service.QuestionService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/question")
@RestController
class QuestionController(
    private val questionService: QuestionService,
) {

    @GetMapping("/list")
    fun getQuestionList(): QueryAllQuestionList =
        questionService.getAllQuestionList()
}
