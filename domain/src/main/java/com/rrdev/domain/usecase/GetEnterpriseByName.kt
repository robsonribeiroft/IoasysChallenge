package com.rrdev.domain.usecase

import com.rrdev.domain.exception.MissingParamsException
import com.rrdev.domain.model.Enterprise
import com.rrdev.domain.repository.EnterpriseRepository
import kotlinx.coroutines.CoroutineScope

class GetEnterpriseByName(
    scope: CoroutineScope,
    private val enterpriseRepository: EnterpriseRepository
): UseCase<List<Enterprise>, GetEnterpriseByName.Params>(scope) {

    override fun run(params: Params?) = when (params) {
        null -> throw MissingParamsException()
        else -> enterpriseRepository.getEnterpriseByName(params.searchForEnterprise)
    }

    data class Params(
        val searchForEnterprise: String
    )

}