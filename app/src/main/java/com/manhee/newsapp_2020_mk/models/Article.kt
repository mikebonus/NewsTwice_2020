package com.manhee.newsapp_2020_mk.ui

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

// This is a 'table' in the Database with several columns...
// Modeling is done through the external plugin 'JSON to Kotlin'..

@Entity(tableName = "articles")

data class Article(

    // 'id' is the primary-key'
    // Make all the fields nullable... (for safety)
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val source: Source?,
    val title: String?,
    val url: String?,
    val urlToImage: String?

) : Serializable            // Inherit Serializable