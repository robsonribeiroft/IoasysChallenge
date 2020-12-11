package com.rrdev.data_remote.util

import android.util.Log
import com.rrdev.data.datasource.local.SessionLocalDataSource
import com.rrdev.data.datasource.local.SessionLocalDataSource.Companion.ACCESS_TOKEN_KEY
import com.rrdev.data.datasource.local.SessionLocalDataSource.Companion.CLIENT_KEY
import com.rrdev.data.datasource.local.SessionLocalDataSource.Companion.UID_KEY
import kotlinx.coroutines.InternalCoroutinesApi
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class AuthenticatorInterceptor(
    private val sessionLocalDataSource: SessionLocalDataSource
): Interceptor {

    @InternalCoroutinesApi
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val request = original.newBuilder().cacheControl(CacheControl.FORCE_NETWORK)

        addingHeaders(request)

        return chain.proceed(request.build())
    }

    @Synchronized
    private fun addingHeaders(request: Request.Builder) {
        val sessionCredentials = sessionLocalDataSource.getCredentials()
        Log.d("loginViewState", sessionCredentials.toString())
        request.apply {
            header(UID_KEY, sessionCredentials.uid)
            header(CLIENT_KEY, sessionCredentials.client)
            header(ACCESS_TOKEN_KEY, sessionCredentials.accessToken)
        }
    }

}