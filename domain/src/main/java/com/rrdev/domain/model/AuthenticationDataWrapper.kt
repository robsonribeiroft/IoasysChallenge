package com.rrdev.domain.model

data class AuthenticationDataWrapper(
    val investor: Investor,
    val success: Boolean
)