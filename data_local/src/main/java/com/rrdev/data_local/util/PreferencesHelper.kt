package com.rrdev.data_local.util

import android.content.Context
import android.content.SharedPreferences
import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey


class PreferencesHelper(private val context: Context) {

    private val sharedPreferences = createEncryptedPreferences()

    private fun createEncryptedPreferences(): SharedPreferences {
        val spec = KeyGenParameterSpec.Builder(
            MasterKey.DEFAULT_MASTER_KEY_ALIAS,
            KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT
        )
            .setBlockModes(KeyProperties.BLOCK_MODE_GCM)
            .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)
            .setKeySize(MasterKey.DEFAULT_AES_GCM_MASTER_KEY_SIZE)
            .build()

        val masterKeyAlias = MasterKey.Builder(context)
            .setKeyGenParameterSpec(spec)
            .build()
        return EncryptedSharedPreferences.create(
            context,
            SHARED_PREFERENCES_APP_NAME,
            masterKeyAlias,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }

    fun saveString(key: String, value: String) = sharedPreferences.edit().run {
        putString(key, value)
        apply()
    }

    fun getString(key: String) = sharedPreferences.getString(key, null)

    fun deleteKey(key: String) = sharedPreferences.edit().run {
        remove(key)
    }

    companion object {
        private const val SHARED_PREFERENCES_APP_NAME =
            "br.com.rrdev.ioasyschallenge.data_local.datasource.PreferencesHelper"
    }
}