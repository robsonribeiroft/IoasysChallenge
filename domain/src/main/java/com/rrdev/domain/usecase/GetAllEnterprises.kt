package com.rrdev.domain.usecase

import com.rrdev.domain.model.Enterprise
import com.rrdev.domain.repository.EnterpriseRepository
import kotlinx.coroutines.CoroutineScope

class GetAllEnterprises(
    scope: CoroutineScope,
    private val enterpriseRepository: EnterpriseRepository
): UseCase<List<Enterprise>, Unit>(scope) {

    override fun run(params: Unit?) = enterpriseRepository.getAllEnterprises()

}