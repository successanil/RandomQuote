package com.cheezycode.randomquote.worker

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.cheezycode.randomquote.QuoteApplication
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import android.util.Log

class QuoteWorker(private val context: Context, params : WorkerParameters) : Worker(context,params) {
    override fun doWork(): Result {
        Log.v("QuoteWorker","Worker called")
        val respository = (context as QuoteApplication).quoteRepository
        CoroutineScope(Dispatchers.IO).launch {
            respository.getQuotesBackground()
        }
        return Result.success()
    }
}