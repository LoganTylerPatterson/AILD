package com.runtimeterror.aild.db

import androidx.room.TypeConverter
import java.util.*


class TypeConverters {

    @TypeConverter
    fun fromDate(date: Date?): Long? {
        return date?.time
    }

    @TypeConverter
    fun toDate(timeStamp: Long?): Date? {
        return timeStamp?.let{
            Date(it)
        }
    }

    @TypeConverter
    fun toUUID(uuid: String?): UUID? {
        return UUID.fromString(uuid)
    }

    @TypeConverter
    fun fromUUID(uuid: UUID?): String? {
        return uuid?.toString()
    }

    @TypeConverter
    fun fromList(list: List<String>?): String? {
        return list?.joinToString(",")
    }

    @TypeConverter
    fun fromString(string: String?): List<String>? {
        val list = string?.split(",")
        return list
    }
}