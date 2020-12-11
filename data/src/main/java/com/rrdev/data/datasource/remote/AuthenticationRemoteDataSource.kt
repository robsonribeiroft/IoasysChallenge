package com.rrdev.data.datasource.remote

import com.rrdev.domain.model.Investor
import kotlinx.coroutines.flow.Flow

interface AuthenticationRemoteDataSource {
    fun logIn(email: String, password: String): Flow<Investor>
}