package com.rrdev.data.repository

import com.rrdev.data.datasource.remote.AuthenticationRemoteDataSource
import com.rrdev.domain.model.Investor
import com.rrdev.domain.repository.AuthenticationRepository
import kotlinx.coroutines.flow.Flow

class AuthenticationRepositoryImpl(
    private val authenticationRemoteDataSource: AuthenticationRemoteDataSource
): AuthenticationRepository {

    override fun logIn(email: String, password: String): Flow<Investor> {
        return authenticationRemoteDataSource.logIn(email, password)
    }
}