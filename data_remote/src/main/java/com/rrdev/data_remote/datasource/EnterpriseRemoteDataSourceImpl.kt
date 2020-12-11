package com.rrdev.data_remote.datasource

import com.rrdev.data.datasource.remote.EnterpriseRemoteDataSource
import com.rrdev.data_remote.mapper.EnterpriseMapper
import com.rrdev.data_remote.service.EnterpriseWebService
import com.rrdev.data_remote.util.RequestWebServiceWrapper
import com.rrdev.domain.model.Enterprise
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class EnterpriseRemoteDataSourceImpl(
    private val enterpriseWebService: EnterpriseWebService,
    private val requestWebServiceWrapper: RequestWebServiceWrapper
): EnterpriseRemoteDataSource {

    override fun getAllEnterprises(): Flow<List<Enterprise>> = flow {
        emit(
            requestWebServiceWrapper.wrapper {
                enterpriseWebService.getAllEnterprises()
            }.enterprises.map(EnterpriseMapper::toDomainEnterprise)
        )
    }

    override fun getEnterpriseByName(enterpriseName: String): Flow<List<Enterprise>> = flow {
        emit(
            requestWebServiceWrapper.wrapper {
                enterpriseWebService.getEnterprisesByName(type = 1, name = enterpriseName)
            }.enterprises.map(EnterpriseMapper::toDomainEnterprise)
        )
    }
}