package com.rrdev.data_local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rrdev.data_local.dao.EnterpriseDao
import com.rrdev.data_local.entity.EnterpriseEntity

@Database(entities = [EnterpriseEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    abstract fun enterpriseDao(): EnterpriseDao

}