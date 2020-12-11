package com.rrdev.base_presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class EnterpriseBinding(
    val city: String,
    val country: String,
    val description: String,
    val emailEnterprise: String,
    val enterpriseName: String,
    val enterpriseType: EnterpriseTypeBinding,
    val facebook: String,
    val id: Int,
    val linkedin: String,
    val ownEnterprise: Boolean,
    val phone: String,
    val photo: String,
    val sharePrice: Double,
    val twitter: String,
    val value: Int
): Parcelable
