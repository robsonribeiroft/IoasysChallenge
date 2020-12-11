package com.rrdev.di

import com.rrdev.data.datasource.remote.AuthenticationRemoteDataSource
import com.rrdev.data.datasource.remote.EnterpriseRemoteDataSource
import com.rrdev.data_remote.datasource.AuthenticationRemoteDataSourceImpl
import com.rrdev.data_remote.datasource.EnterpriseRemoteDataSourceImpl
import com.rrdev.data_remote.service.AuthenticationWebService
import com.rrdev.data_remote.service.EnterpriseWebService
import com.rrdev.data_remote.util.BASE_URL
import com.rrdev.data_remote.util.RequestWebServiceWrapper
import com.rrdev.data_remote.util.RequestWebServiceWrapperImpl
import com.rrdev.data_remote.util.ServiceWebFactory
import com.rrdev.data_remote.util.ServiceWebFactory.createService
import com.rrdev.data_remote.util.ServiceWebFactory.provideOkHttpClient
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dataRemoteModule = module {
    single { provideOkHttpClient(get()) }
    single {
        createService(
            okHttpClient = get(),
            BASE_URL
        ) as EnterpriseWebService
    }
    single {
        createService(
            okHttpClient = get(),
            BASE_URL
        ) as AuthenticationWebService
    }
    single<RequestWebServiceWrapper> { RequestWebServiceWrapperImpl(get(), androidApplication().resources) }
    single<EnterpriseRemoteDataSource> { EnterpriseRemoteDataSourceImpl(get(), get()) }
    single<AuthenticationRemoteDataSource> { AuthenticationRemoteDataSourceImpl(get(), get()) }
}