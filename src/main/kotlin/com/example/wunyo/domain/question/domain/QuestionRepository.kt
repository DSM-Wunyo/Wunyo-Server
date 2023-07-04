package com.example.wunyo.domain.question.domain

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface QuestionRepository : CrudRepository<QuestionEntity, Int> {
}
