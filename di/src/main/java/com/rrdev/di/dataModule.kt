package com.rrdev.di

import com.rrdev.data.repository.AuthenticationRepositoryImpl
import com.rrdev.data.repository.EnterpriseRepositoryImpl
import com.rrdev.domain.repository.AuthenticationRepository
import com.rrdev.domain.repository.EnterpriseRepository
import org.koin.dsl.module

val dataModule = module {
    single<AuthenticationRepository> { AuthenticationRepositoryImpl(get()) }
    single<EnterpriseRepository> { EnterpriseRepositoryImpl(get(), get()) }
}