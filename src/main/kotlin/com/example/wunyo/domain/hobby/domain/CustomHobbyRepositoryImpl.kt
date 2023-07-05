package com.example.wunyo.domain.hobby.domain

import com.example.wunyo.domain.hobby.domain.QHobbyEntity.hobbyEntity
import com.example.wunyo.domain.result.domain.QResultEntity.resultEntity
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Component

@Component
class CustomHobbyRepositoryImpl(
    private val jpaQueryFactory: JPAQueryFactory,
) : CustomHobbyRepository {

    override fun findHobby(hobbyAge: Int, isActive: Boolean, isSolo: Boolean): HobbyEntity =
        jpaQueryFactory
            .selectFrom(hobbyEntity)
            .where(
                hobbyEntity.hobbyAge.eq(hobbyAge),
                hobbyEntity.active.eq(isActive),
                hobbyEntity.solo.eq(isSolo)
            )
            .fetchFirst()

    override fun countHobby(): Map<String, String> =
        jpaQueryFactory
            .select(
                resultEntity.hobby.name,
                resultEntity.count()
            )
            .from(resultEntity)
            .groupBy(resultEntity.hobby.name)
            .fetch()
            .associate { resultEntity.hobby.name.toString() to resultEntity.count().toString() }
}
