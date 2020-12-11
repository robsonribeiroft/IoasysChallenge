package com.rrdev.base_presentation.mapper

import com.rrdev.base_presentation.model.EnterpriseBinding
import com.rrdev.base_presentation.model.EnterpriseTypeBinding
import com.rrdev.domain.model.Enterprise
import com.rrdev.domain.model.EnterpriseType

object EnterpriseMapper {

    fun toPresentation(enterprise: Enterprise) = EnterpriseBinding(
        city = enterprise.city,
        country = enterprise.country,
        description = enterprise.description,
        emailEnterprise = enterprise.emailEnterprise,
        enterpriseName = enterprise.enterpriseName,
        enterpriseType = toPresentationEnterpriseType(enterprise.enterpriseType),
        facebook = enterprise.facebook,
        id = enterprise.id,
        linkedin = enterprise.linkedin,
        ownEnterprise = enterprise.ownEnterprise,
        phone = enterprise.phone,
        photo = enterprise.photo,
        sharePrice = enterprise.sharePrice,
        twitter = enterprise.twitter,
        value = enterprise.value
    )

    private fun toPresentationEnterpriseType(enterpriseType: EnterpriseType) = EnterpriseTypeBinding(
        enterpriseTypeName = enterpriseType.enterpriseTypeName,
        id = enterpriseType.id
    )
}