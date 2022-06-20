package com.cheezycode.randomquote.utils

import android.util.Log
import com.cheezycode.randomquote.QuoteApplication
import com.cheezycode.randomquote.db.QuoteDatabase
import com.cheezycode.randomquote.models.CrashRecords
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.PrintWriter
import java.io.StringWriter
import java.util.*

class CrashUtils {
    companion object {
        val quoteDatabase = QuoteDatabase.getDatabase(QuoteApplication.getApplication()?.applicationContext!!)
        fun logCrash(ex : Throwable) {

            val sw = StringWriter()
            val pw = PrintWriter(sw)
            ex.printStackTrace(pw)
            Log.e("error", sw.toString())
            var crashRecord = CrashRecords()
            crashRecord.crashString = sw.toString()
            crashRecord.crashTiming = Date(System.currentTimeMillis())

            CoroutineScope(Dispatchers.IO).launch {
                quoteDatabase.crashRecordDao().addCrash(crashRecord)
            }

        }
    }
}