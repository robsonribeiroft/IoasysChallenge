package com.rrdev.data_local.datasource

import com.rrdev.data.datasource.local.SessionLocalDataSource
import com.rrdev.data.datasource.local.SessionLocalDataSource.Companion.ACCESS_TOKEN_KEY
import com.rrdev.data.datasource.local.SessionLocalDataSource.Companion.CLIENT_KEY
import com.rrdev.data.datasource.local.SessionLocalDataSource.Companion.UID_KEY
import com.rrdev.data.model.SessionCredentials
import com.rrdev.data_local.util.PreferencesHelper

class SessionLocalDataSourceImpl(
    private val preferencesHelper: PreferencesHelper
): SessionLocalDataSource {

    override fun saveAccessToken(accessToken: String) {
        preferencesHelper.saveString(ACCESS_TOKEN_KEY, accessToken)
    }

    override fun saveClient(client: String) {
        preferencesHelper.saveString(CLIENT_KEY, client)
    }

    override fun saveUid(uid: String) {
        preferencesHelper.saveString(UID_KEY, uid)
    }

    override fun deleteCredentials() {
        with(preferencesHelper){
            deleteKey(ACCESS_TOKEN_KEY)
            deleteKey(CLIENT_KEY)
            deleteKey(UID_KEY)
        }
    }

    override fun getCredentials(): SessionCredentials = SessionCredentials(
        accessToken = preferencesHelper.getString(ACCESS_TOKEN_KEY) ?: "",
        client = preferencesHelper.getString(CLIENT_KEY) ?: "",
        uid = preferencesHelper.getString(UID_KEY) ?: ""
    )
}