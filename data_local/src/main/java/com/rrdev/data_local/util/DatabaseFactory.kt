package com.rrdev.data_local.util

import android.content.Context
import androidx.room.Room
import com.rrdev.data_local.AppDatabase
import com.rrdev.data_local.dao.EnterpriseDao

object DatabaseFactory {

    fun createDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

    fun createEnterpriseDao(db: AppDatabase): EnterpriseDao = db.enterpriseDao()

    private const val DATABASE_NAME = "APP_DATABASE.db"
}