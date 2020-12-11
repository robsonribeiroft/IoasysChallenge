package com.rrdev.domain.usecase

import com.rrdev.domain.exception.EmptyFieldException
import com.rrdev.domain.exception.MissingParamsException
import com.rrdev.domain.model.Investor
import com.rrdev.domain.repository.AuthenticationRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class LogIn(
    scope: CoroutineScope,
    private val authenticationRepository: AuthenticationRepository
): UseCase<Investor, LogIn.Params>(scope) {

    override fun run(params: Params?): Flow<Investor> = when {
        params == null -> throw MissingParamsException()
        params.email.isBlank() -> throw EmptyFieldException("Email")
        params.password.isBlank() -> throw EmptyFieldException("Password")
        else -> authenticationRepository.logIn(params.email, params.password)
    }

    data class Params(
        val email: String,
        val password: String
    )
}