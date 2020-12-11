package com.rrdev.domain.model

data class Enterprise(
    val city: String,
    val country: String,
    val description: String,
    val emailEnterprise: String,
    val enterpriseName: String,
    val enterpriseType: EnterpriseType,
    val facebook: String,
    val id: Int,
    val linkedin: String,
    val ownEnterprise: Boolean,
    val phone: String,
    val photo: String,
    val sharePrice: Double,
    val twitter: String,
    val value: Int
)
