package com.rrdev.data_remote.model

import com.google.gson.annotations.SerializedName

data class Portfolio(
    @SerializedName("enterprises_number") val enterprisesNumber: Int
)
