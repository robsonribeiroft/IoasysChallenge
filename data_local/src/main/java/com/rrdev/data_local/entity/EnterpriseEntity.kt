package com.rrdev.data_local.entity

import androidx.room.*

@Entity
data class EnterpriseEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo val city: String,
    @ColumnInfo val country: String,
    @ColumnInfo val description: String,
    @ColumnInfo val emailEnterprise: String,
    @ColumnInfo val enterpriseName: String,
    @ColumnInfo val facebook: String,
    @ColumnInfo val linkedin: String,
    @ColumnInfo val ownEnterprise: Boolean,
    @ColumnInfo val phone: String,
    @ColumnInfo val photo: String,
    @ColumnInfo val sharePrice: Double,
    @ColumnInfo val twitter: String,
    @ColumnInfo val value: Int,
    @Embedded val enterpriseType: EnterpriseTypeEntity
)