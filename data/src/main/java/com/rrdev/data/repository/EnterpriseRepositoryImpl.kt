package com.rrdev.data.repository

import com.rrdev.data.datasource.local.EnterpriseLocalDataSource
import com.rrdev.data.datasource.remote.EnterpriseRemoteDataSource
import com.rrdev.domain.model.DataWrapper
import com.rrdev.domain.model.Enterprise
import com.rrdev.domain.repository.EnterpriseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach

class EnterpriseRepositoryImpl(
    private val localDataSource: EnterpriseLocalDataSource,
    private val remoteDataSource: EnterpriseRemoteDataSource
): EnterpriseRepository {

    override fun getAllEnterprises(): Flow<DataWrapper<List<Enterprise>>> {
        return try {
            remoteDataSource.getAllEnterprises()
                .onEach { listRemoteEnterprise ->
                    localDataSource.saveAll(listRemoteEnterprise)
                }
                .map { listRemoteEnterprise ->
                    DataWrapper(listRemoteEnterprise.sortedBy(Enterprise::enterpriseName))
                }
        }catch (e: Exception){
            localDataSource.getAll().map { listLocalEnterprise ->
                DataWrapper(listLocalEnterprise, e)
            }
        }
    }

    override fun getEnterpriseByName(enterpriseName: String) =
        localDataSource.getEnterpriseByName(enterpriseName)

}