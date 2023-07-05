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
                hobbyEntity.solo.eq(isSolo),
            )
            .fetchFirst()

    override fun countHobby(): Map<String, Int> {
        val result = jpaQueryFactory
            .select(
                resultEntity.hobby.name,
                resultEntity.id.count(),
            )
            .from(resultEntity)
            .groupBy(resultEntity.hobby.name)
            .fetch()

        return result.associate { tuple ->
            val hobby = tuple.get(resultEntity.hobby.name)
            val count = tuple.get(resultEntity.id.count())!!.toInt()
            hobby.toString() to count
        }
    }
}
