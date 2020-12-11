package com.rrdev.di

import com.rrdev.data.datasource.local.EnterpriseLocalDataSource
import com.rrdev.data.datasource.local.SessionLocalDataSource
import com.rrdev.data_local.datasource.EnterpriseLocalDataSourceImpl
import com.rrdev.data_local.datasource.SessionLocalDataSourceImpl
import com.rrdev.data_local.util.DatabaseFactory.createDatabase
import com.rrdev.data_local.util.DatabaseFactory.createEnterpriseDao
import com.rrdev.data_local.util.PreferencesHelper
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dataLocalModule = module {
    single { PreferencesHelper(androidApplication()) }
    single<SessionLocalDataSource> { SessionLocalDataSourceImpl(get()) }

    single { createDatabase(androidApplication()) }
    single { createEnterpriseDao(get()) }

    single<EnterpriseLocalDataSource> { EnterpriseLocalDataSourceImpl(get()) }
}