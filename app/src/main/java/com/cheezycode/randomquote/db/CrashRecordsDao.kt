package com.cheezycode.randomquote.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.cheezycode.randomquote.models.CrashRecords
import com.cheezycode.randomquote.models.Result

@Dao
interface CrashRecordsDao {

    @Insert
    suspend fun addCrash(crash: CrashRecords)

    @Query("SELECT * FROM crashrecords")
    suspend fun getCrashRecords() : List<CrashRecords>
}