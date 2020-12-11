package com.rrdev.data_remote.model

import com.google.gson.annotations.SerializedName

data class EnterpriseType(
    @SerializedName("enterprise_type_name") val enterpriseTypeName: String? = null,
    @SerializedName("id") val id: Int? = null
)
