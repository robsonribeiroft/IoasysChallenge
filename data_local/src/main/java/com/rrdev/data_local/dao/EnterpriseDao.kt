package com.rrdev.data_local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rrdev.data_local.entity.EnterpriseEntity

@Dao
interface EnterpriseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<EnterpriseEntity>)

    @Query("SELECT * FROM enterpriseentity ORDER BY enterpriseName COLLATE LOCALIZED ASC")
    fun getAll(): List<EnterpriseEntity>

    @Query("SELECT * FROM enterpriseentity WHERE enterpriseName LIKE '%'||:searchForEnterpriseName||'%' ORDER BY enterpriseName COLLATE LOCALIZED ASC")
    fun getEnterpriseByName(searchForEnterpriseName: String): List<EnterpriseEntity>
}