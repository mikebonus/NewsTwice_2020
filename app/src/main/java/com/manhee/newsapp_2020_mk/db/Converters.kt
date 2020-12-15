package com.manhee.newsapp_2020_mk.ui

import androidx.room.TypeConverter

/** 'Room' only deals with primitive data-types (ie. NOT customized class)
 * So in order to deal with the customized data-type (ie. 'SOURCE' from REST-API),
 * we need to create this class that converts the CUSTOMIZED-data type into..
 * primitive data-type (ie. In this case 'String') **/
class Converters {

    @TypeConverter
    fun fromSource(source: Source): String {
        return source.name
    }

    @TypeConverter
    fun toSource(name: String): Source {
        return Source(name, name)
    }
}