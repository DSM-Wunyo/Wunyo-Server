package com.example.wunyo.domain.user.service

import com.example.wunyo.domain.user.domain.UserEntity
import com.example.wunyo.domain.user.domain.UserRepository
import com.example.wunyo.domain.user.presentation.dto.request.UserInputInfoRequest
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
) {

    fun userInputInfo(request: UserInputInfoRequest) {
        if (!userRepository.existsByName(request.name)) {
            userRepository.save(
                UserEntity(
                    name = request.name,
                    sex = request.sex,
                    birthday = request.birthday,
                )
            )
        }
    }
}
