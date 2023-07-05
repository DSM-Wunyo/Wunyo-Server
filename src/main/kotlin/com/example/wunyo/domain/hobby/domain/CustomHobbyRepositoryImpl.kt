package com.example.wunyo.domain.hobby.domain

import com.example.wunyo.domain.hobby.domain.QHobbyEntity.hobbyEntity
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Component

@Component
class CustomHobbyRepositoryImpl(
    private val jpaQueryFactory: JPAQueryFactory,
) : CustomHobbyRepository {

    override fun findByHobbyAgeAndActiveAndSolo(hobbyAge: Int, isActive: Boolean, isSolo: Boolean): HobbyEntity =
        jpaQueryFactory
            .selectFrom(hobbyEntity)
            .where(
                hobbyEntity.hobbyAge.eq(hobbyAge),
                hobbyEntity.active.eq(isActive),
                hobbyEntity.solo.eq(isSolo)
            )
            .fetchFirst()
}
