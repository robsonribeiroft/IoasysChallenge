package com.rrdev.data_remote.service

import com.rrdev.data_remote.model.EnterprisesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface EnterpriseWebService {

    @GET("enterprises")
    fun getAllEnterprises(): Call<EnterprisesResponse>

    @GET("enterprises")
    fun getEnterprisesByName(
        @Query("enterprise_types") type: Int,
        @Query("name") name: String
    ): Call<EnterprisesResponse>

}