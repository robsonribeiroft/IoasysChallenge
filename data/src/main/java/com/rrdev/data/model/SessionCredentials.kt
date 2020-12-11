package com.rrdev.data.model

data class SessionCredentials(
    val accessToken: String,
    val client: String,
    val uid: String
)