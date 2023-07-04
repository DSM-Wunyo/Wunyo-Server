package com.example.wunyo.domain.user.presentation

import com.example.wunyo.domain.user.presentation.dto.request.UserInputInfoRequest
import com.example.wunyo.domain.user.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/user")
@RestController
class UserController(
    private val userService: UserService
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/info")
    fun userInputInfo(@RequestBody request: UserInputInfoRequest) {
        userService.userInputInfo(request)
    }
}
