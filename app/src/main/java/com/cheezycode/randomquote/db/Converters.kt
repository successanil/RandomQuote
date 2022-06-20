package com.cheezycode.randomquote.db

import androidx.room.TypeConverter
import java.util.*

class Converters {
    @TypeConverter
    fun  covertToLongFromDate(d : Date) : Long {
        return d.time
    }

    @TypeConverter
    fun covertToDateFromLong(lng:Long) : Date {
        return Date(lng)
    }
}