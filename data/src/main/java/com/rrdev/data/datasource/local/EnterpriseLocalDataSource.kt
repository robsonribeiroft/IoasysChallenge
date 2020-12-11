package com.rrdev.data.datasource.local

import com.rrdev.domain.model.Enterprise
import kotlinx.coroutines.flow.Flow

interface EnterpriseLocalDataSource {
    fun saveAll(list: List<Enterprise>)
    fun getAll(): Flow<List<Enterprise>>
    fun getEnterpriseByName(enterpriseName: String): Flow<List<Enterprise>>
}