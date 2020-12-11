package com.rrdev.data_remote.util

import okhttp3.Headers
import retrofit2.Call

interface RequestWebServiceWrapper {

    suspend fun <B> wrapper(
        request: suspend ()-> Call<B>
    ): B

    suspend fun <B> wrapperWithHeader(
        request: suspend ()-> Call<B>
    ): B
}