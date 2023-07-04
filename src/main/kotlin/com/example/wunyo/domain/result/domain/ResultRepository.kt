package com.example.wunyo.domain.result.domain

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ResultRepository : CrudRepository<ResultEntity, Int>, CustomResultRepository {

}