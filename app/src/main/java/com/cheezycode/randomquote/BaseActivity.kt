package com.cheezycode.randomquote

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.cheezycode.randomquote.utils.CrashUtils
import java.io.PrintWriter
import java.io.StringWriter

open class BaseActivity : AppCompatActivity() {

    val handleAppCrash = Thread.UncaughtExceptionHandler { thread, ex ->

        CrashUtils.logCrash(ex)

             //send email here
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)



    }
}