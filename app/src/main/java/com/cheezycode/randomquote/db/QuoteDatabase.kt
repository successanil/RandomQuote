package com.cheezycode.randomquote.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.cheezycode.randomquote.models.CrashRecords
import com.cheezycode.randomquote.models.Result

@Database(entities = [Result::class, CrashRecords::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class QuoteDatabase : RoomDatabase() {

    abstract fun quoteDao() : QuoteDao
    abstract fun crashRecordDao() : CrashRecordsDao

    companion object{
        @Volatile
        private var INSTANCE: QuoteDatabase? = null

        fun getDatabase(context: Context): QuoteDatabase {
            if (INSTANCE == null) {
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context,
                        QuoteDatabase::class.java,
                        "quoteDB")
                        .build()
                }
            }
            return INSTANCE!!
        }
    }
}