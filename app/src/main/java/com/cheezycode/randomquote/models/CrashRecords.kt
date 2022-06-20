package com.cheezycode.randomquote.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "crashrecords")
class CrashRecords () {
    @PrimaryKey(autoGenerate = true)
    var crashId: Int? = null

    var crashString: String = ""
    var crashTiming: Date? = null
}