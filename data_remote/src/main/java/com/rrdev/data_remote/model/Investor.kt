package com.rrdev.data_remote.model

import com.google.gson.annotations.SerializedName

data class Investor(
    @SerializedName("balance") val balance: Double? = null,
    @SerializedName("city") val city: String? = null,
    @SerializedName("country") val country: String? = null,
    @SerializedName("email") val email: String? = null,
    @SerializedName("first_access") val firstAccess: Boolean? = null,
    @SerializedName("id") val id: Int? = null,
    @SerializedName("investor_name") val investorName: String? = null,
    @SerializedName("photo") val photo: String? = null,
    @SerializedName("portfolio") val portfolio: Portfolio? = null,
    @SerializedName("portfolio_value") val portfolioValue: Double? = null,
    @SerializedName("super_angel") val superAngel: Boolean? = null
)
