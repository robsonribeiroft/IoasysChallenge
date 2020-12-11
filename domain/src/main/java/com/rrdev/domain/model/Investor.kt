package com.rrdev.domain.model

data class Investor(
    val balance: Double,
    val city: String,
    val country: String,
    val email: String,
    val firstAccess: Boolean,
    val id: Int,
    val investorName: String,
    val photo: String,
    val portfolio: Portfolio,
    val portfolioValue: Double,
    val superAngel: Boolean
)
