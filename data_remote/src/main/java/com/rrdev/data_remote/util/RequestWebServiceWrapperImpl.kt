package com.rrdev.data_remote.util

import android.content.res.Resources
import com.rrdev.data.datasource.local.SessionLocalDataSource
import com.rrdev.data_remote.R
import retrofit2.Call
import retrofit2.Response

class RequestWebServiceWrapperImpl(
    private val sessionLocalDataSource: SessionLocalDataSource,
    private val resources: Resources
): RequestWebServiceWrapper {

    override suspend fun <B> wrapper(request: suspend () -> Call<B>): B {
        try {
            val response: Response<B> = request().execute()
            if (response.isSuccessful)
                return response.body()!!
            throw Exception("Error (${response.code()})\n${response.message()}")

        }catch (e: Exception){
            throw Exception(resources.getString(R.string.generic_error, e.message))
        }
    }

    override suspend fun <B> wrapperWithHeader(request: suspend () -> Call<B>): B {
        try {
            val response: Response<B> = request().execute()
            if (response.isSuccessful){

                sessionLocalDataSource.saveAccessToken(response.headers()[ACCESS_TOKEN_KEY]!!)
                sessionLocalDataSource.saveClient(response.headers()[CLIENT_KEY]!!)
                sessionLocalDataSource.saveUid(response.headers()[UID_KEY]!!)

                return response.body()!!
            }
            throw Exception("Error (${response.code()})\n${response.message()}")

        }catch (e: Exception){
            throw Exception(resources.getString(R.string.generic_error, e.message))
        }
    }

    companion object{
        private const val ACCESS_TOKEN_KEY = "access-token"
        private const val CLIENT_KEY = "client"
        private const val UID_KEY = "uid"
    }


}