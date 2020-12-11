package com.rrdev.data.datasource.remote

import com.rrdev.domain.model.Enterprise
import kotlinx.coroutines.flow.Flow

interface EnterpriseRemoteDataSource {
    fun getAllEnterprises(): Flow<List<Enterprise>>
    fun getEnterpriseByName(enterpriseName: String): Flow<List<Enterprise>>
}