package com.rrdev.base_presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class EnterpriseTypeBinding(
    val enterpriseTypeName: String,
    val id: Int
): Parcelable
