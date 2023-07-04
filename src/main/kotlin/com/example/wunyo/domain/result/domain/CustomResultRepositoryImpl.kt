package com.example.wunyo.domain.result.domain

import com.example.wunyo.domain.result.domain.QResultEntity.resultEntity
import com.example.wunyo.domain.user.domain.QUserEntity.userEntity
import com.example.wunyo.domain.user.domain.type.Sex
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class CustomResultRepositoryImpl(
    private val jpaQueryFactory: JPAQueryFactory,
) : CustomResultRepository {

    override fun findAllResultByNameAndSexAndBirthday(name: String, sex: Sex, birthday: LocalDate): List<ResultEntity> =
        jpaQueryFactory
            .selectFrom(resultEntity)
            .join(userEntity)
            .on(resultEntity.user.id.eq(userEntity.id))
            .where(
                userEntity.name.eq(name),
                userEntity.sex.eq(sex),
                userEntity.birthday.eq(birthday),
            )
            .fetch()
}
