package com.rrdev.data.repository

import com.rrdev.data.datasource.local.EnterpriseLocalDataSource
import com.rrdev.data.datasource.remote.EnterpriseRemoteDataSource
import com.rrdev.domain.model.Enterprise
import com.rrdev.domain.repository.EnterpriseRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach

class EnterpriseRepositoryImpl(
    private val localDataSource: EnterpriseLocalDataSource,
    private val remoteDataSource: EnterpriseRemoteDataSource
): EnterpriseRepository {

    override fun getAllEnterprises() = remoteDataSource.getAllEnterprises()
        .map { it.sortedBy(Enterprise::enterpriseName) }
        .onEach { localDataSource.saveAll(it) }
        .catch { localDataSource.getAll() }

    override fun getEnterpriseByName(enterpriseName: String) =
        localDataSource.getEnterpriseByName(enterpriseName)

}