package com.rrdev.domain.repository

import com.rrdev.domain.model.Investor
import kotlinx.coroutines.flow.Flow

interface AuthenticationRepository {
    fun logIn(email: String, password: String): Flow<Investor>
}