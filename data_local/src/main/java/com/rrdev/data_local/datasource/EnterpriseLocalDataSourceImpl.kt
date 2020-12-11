package com.rrdev.data_local.datasource

import com.rrdev.data.datasource.local.EnterpriseLocalDataSource
import com.rrdev.data_local.dao.EnterpriseDao
import com.rrdev.data_local.mapper.EnterpriseEntityMapper
import com.rrdev.domain.model.Enterprise
import kotlinx.coroutines.flow.flow

class EnterpriseLocalDataSourceImpl(
    private val enterpriseDao: EnterpriseDao
): EnterpriseLocalDataSource {
    override fun saveAll(list: List<Enterprise>) =
        enterpriseDao.insertAll(list.map(EnterpriseEntityMapper::fromDomain))

    override fun getAll() = flow {
        emit(
            enterpriseDao.getAll().map(EnterpriseEntityMapper::toDomain)
        )
    }

    override fun getEnterpriseByName(enterpriseName: String) = flow {
        emit(
            enterpriseDao.getEnterpriseByName(enterpriseName).map(EnterpriseEntityMapper::toDomain)
        )
    }
}