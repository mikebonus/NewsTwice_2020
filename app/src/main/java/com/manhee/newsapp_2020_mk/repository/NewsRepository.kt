package com.manhee.newsapp_2020_mk.repository

import com.androiddevs.mvvmnewsapp.api.RetrofitInstance
import com.manhee.newsapp_2020_mk.ui.Article
import com.manhee.newsapp_2020_mk.ui.ArticleDatabase

// 5 functions to interact with the REST-API //
class NewsRepository(
    val db: ArticleDatabase
) {

    // ★★★★★ Key-Function:
    // function #1: coming from remote data-source
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    // function #2: coming from remote data-source
    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)

    // function #3: coming from local database
    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    // function #4: coming from local database
    fun getSavedNews() = db.getArticleDao().getAllArticles()

    // function #5: coming from local database
    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)
}