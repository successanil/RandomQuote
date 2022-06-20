package com.cheezycode.randomquote.utils

import android.util.Log
import java.io.PrintWriter
import java.io.StringWriter

class CrashUtils {
    companion object {
        fun logCrash(ex : Throwable) {
            val sw = StringWriter()
            val pw = PrintWriter(sw)
            ex.printStackTrace(pw)
            Log.e("error", sw.toString())
        }
    }
}