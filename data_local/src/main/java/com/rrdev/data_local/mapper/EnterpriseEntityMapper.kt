package com.rrdev.data_local.mapper

import com.rrdev.data_local.entity.EnterpriseEntity
import com.rrdev.data_local.entity.EnterpriseTypeEntity
import com.rrdev.domain.model.Enterprise
import com.rrdev.domain.model.EnterpriseType

object EnterpriseEntityMapper {

    fun toDomain(enterpriseEntity: EnterpriseEntity) = Enterprise(
        city = enterpriseEntity.city ?: "",
        country = enterpriseEntity.country ?: "",
        description = enterpriseEntity.description ?: "",
        emailEnterprise = enterpriseEntity.emailEnterprise ?: "",
        enterpriseName = enterpriseEntity.enterpriseName ?: "",
        enterpriseType = toDomainEnterpriseTypeEntity(enterpriseEntity.enterpriseType),
        facebook = enterpriseEntity.facebook ?: "",
        id = enterpriseEntity.id ?: 0,
        linkedin = enterpriseEntity.linkedin ?: "",
        ownEnterprise = enterpriseEntity.ownEnterprise,
        phone = enterpriseEntity.phone ?: "",
        photo = enterpriseEntity.photo ?: "",
        sharePrice = enterpriseEntity.sharePrice ?: 0.0,
        twitter = enterpriseEntity.twitter ?: "",
        value = enterpriseEntity.value ?: 0
    )

    private fun toDomainEnterpriseTypeEntity(enterpriseTypeEntity: EnterpriseTypeEntity) = EnterpriseType (
        enterpriseTypeName = enterpriseTypeEntity.enterpriseTypeName ?: "",
        id = enterpriseTypeEntity.enterpriseTypeId ?: 0
    )

    fun fromDomain(enterprise: Enterprise) = EnterpriseEntity(
        city = enterprise.city ?: "",
        country = enterprise.country ?: "",
        description = enterprise.description ?: "",
        emailEnterprise = enterprise.emailEnterprise ?: "",
        enterpriseName = enterprise.enterpriseName ?: "",
        enterpriseType = fromDomainEnterpriseType(enterprise.enterpriseType),
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

    private fun fromDomainEnterpriseType(enterpriseType: EnterpriseType) = EnterpriseTypeEntity (
        enterpriseTypeName = enterpriseType.enterpriseTypeName ?: "",
        enterpriseTypeId = enterpriseType.id ?: 0
    )
}