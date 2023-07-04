package com.example.wunyo.domain.question.service

import com.example.wunyo.domain.question.domain.QuestionRepository
import com.example.wunyo.domain.question.presentation.dto.response.QueryAllQuestionList
import com.example.wunyo.domain.question.presentation.dto.response.QueryAllQuestionList.QuestionElement
import org.springframework.stereotype.Service

@Service
class QuestionService(
    private val questionRepository: QuestionRepository,
) {

    fun getAllQuestionList(): QueryAllQuestionList {
        val questionList = questionRepository.findAll()

        val response = questionList.map {
            QuestionElement(
                questionId = it.id,
                questionContent = it.content,
            )
        }

        return QueryAllQuestionList(response)
    }
}
