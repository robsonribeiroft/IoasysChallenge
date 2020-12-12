package com.rrdev.domain.repository

import com.rrdev.domain.model.DataWrapper
import com.rrdev.domain.model.Enterprise
import kotlinx.coroutines.flow.Flow

interface EnterpriseRepository {
    fun getAllEnterprises(): Flow<DataWrapper<List<Enterprise>>>
    fun getEnterpriseByName(enterpriseName: String): Flow<List<Enterprise>>
}