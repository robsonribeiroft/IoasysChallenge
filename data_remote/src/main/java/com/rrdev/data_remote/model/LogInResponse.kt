package com.rrdev.data_remote.model

import com.google.gson.annotations.SerializedName

data class LogInResponse(
    @SerializedName("investor") val investor: Investor? = null,
    @SerializedName("success") val success: Boolean? = null
)
