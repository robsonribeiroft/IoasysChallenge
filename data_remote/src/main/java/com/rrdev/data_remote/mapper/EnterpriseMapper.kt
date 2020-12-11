package com.rrdev.data_remote.mapper

import com.rrdev.domain.model.Enterprise
import com.rrdev.domain.model.EnterpriseType
import com.rrdev.data_remote.model.Enterprise as EnterpriseDataRemote
import com.rrdev.data_remote.model.EnterpriseType as EnterpriseTypeDataRemote


object EnterpriseMapper {

    fun toDomainEnterprise(enterprise: EnterpriseDataRemote) = Enterprise(
            city = enterprise.city ?: "",
            country = enterprise.country ?: "",
            description = enterprise.description ?: "",
            emailEnterprise = enterprise.emailEnterprise ?: "",
            enterpriseName = enterprise.enterpriseName ?: "",
            enterpriseType = toDomainEnterpriseType(enterprise.enterpriseType),
            facebook = enterprise.facebook ?: "",
            id = enterprise.id ?: 0,
            linkedin = enterprise.linkedin ?: "",
            ownEnterprise = enterprise.ownEnterprise,
            phone = enterprise.phone ?: "",
            photo = enterprise.photo ?: "",
            sharePrice = enterprise.sharePrice ?: 0.0,
            twitter = enterprise.twitter ?: "",
            value = enterprise.value ?: 0
    )

    private fun toDomainEnterpriseType(enterpriseType: EnterpriseTypeDataRemote?) = EnterpriseType(
            enterpriseTypeName = enterpriseType?.enterpriseTypeName ?: "",
            id = enterpriseType?.id ?: 0
    )
}