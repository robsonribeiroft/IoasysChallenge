package com.rrdev.data_remote.model

import com.google.gson.annotations.SerializedName

data class Enterprise(
    @SerializedName("city") val city: String? = null,
    @SerializedName("country") val country: String? = null,
    @SerializedName("description") val description: String? = null,
    @SerializedName("email_enterprise") val emailEnterprise: String? = null,
    @SerializedName("enterprise_name") val enterpriseName: String? = null,
    @SerializedName("enterprise_type") val enterpriseType: EnterpriseType? = null,
    @SerializedName("facebook") val facebook: String? = null,
    @SerializedName("id") val id: Int? = null,
    @SerializedName("linkedin") val linkedin: String? = null,
    @SerializedName("own_enterprise") val ownEnterprise: Boolean = false,
    @SerializedName("phone") val phone: String? = null,
    @SerializedName("photo") val photo: String? = null,
    @SerializedName("share_price") val sharePrice: Double?,
    @SerializedName("twitter") val twitter: String? = null,
    @SerializedName("value") val value: Int? = null
)
