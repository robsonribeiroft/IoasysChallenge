package com.rrdev.data_remote.util

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.rrdev.data.datasource.local.SessionLocalDataSource
import okhttp3.Dispatcher
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ServiceWebFactory {

    inline fun <reified T> createService(
        okHttpClient: OkHttpClient,
        url: String
    ): T {
        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
        return retrofit.create()
    }

    private fun dispatcher() = Dispatcher().apply {
        maxRequests = 1
        maxRequestsPerHost = 1
    }

    fun provideOkHttpClient(
        sessionLocalDataSource: SessionLocalDataSource
    ): OkHttpClient = OkHttpClient.Builder()
        .dispatcher(dispatcher())
        .addInterceptor(AuthenticatorInterceptor(sessionLocalDataSource))
        .build()
}