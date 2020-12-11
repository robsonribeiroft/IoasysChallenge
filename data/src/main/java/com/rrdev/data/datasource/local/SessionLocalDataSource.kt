package com.rrdev.data.datasource.local

import com.rrdev.data.model.SessionCredentials
import kotlinx.coroutines.flow.Flow

interface SessionLocalDataSource {
    companion object{
        const val ACCESS_TOKEN_KEY = "access-token"
        const val CLIENT_KEY = "client"
        const val UID_KEY = "uid"
    }
    fun saveAccessToken(accessToken: String)
    fun saveClient(client: String)
    fun saveUid(uid: String)
    fun deleteCredentials()
    fun getCredentials(): SessionCredentials
}