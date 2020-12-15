package com.manhee.newsapp_2020_mk.ui


// Modeling is done through the external plugin 'JSON to Kotlin'..

data class NewsResponse(
    val articles: MutableList<Article>,         // 9 fields...
    val status: String,
    val totalResults: Int
)