package com.rrdev.data_remote.datasource

import com.rrdev.data.datasource.remote.AuthenticationRemoteDataSource
import com.rrdev.data_remote.mapper.AuthenticationMapper
import com.rrdev.data_remote.model.LogInBodyRequest
import com.rrdev.data_remote.service.AuthenticationWebService
import com.rrdev.data_remote.util.RequestWebServiceWrapper
import com.rrdev.domain.model.Investor
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AuthenticationRemoteDataSourceImpl(
    private val authenticationWebService: AuthenticationWebService,
    private val requestWebServiceWrapper: RequestWebServiceWrapper
): AuthenticationRemoteDataSource {

    override fun logIn(email: String, password: String): Flow<Investor> = flow {
        emit(
            AuthenticationMapper.toDomainInvestor(requestWebServiceWrapper.wrapperWithHeader {
                authenticationWebService.logIn(LogInBodyRequest(email, password))
            })
        )
    }

}