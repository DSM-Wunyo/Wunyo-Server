package com.example.wunyo.domain.question.presentation.dto.response

data class QueryAllQuestionList(
    val questionList: List<QuestionElement>,
) {
    data class QuestionElement(
        val questionId: Int,
        val questionContent: String,
    )
}
