package com.manhee.newsapp_2020_mk.ui

import androidx.lifecycle.LiveData
import androidx.room.*

// DAO is an interface containing 3 Fundamental Methods to
// interact with local database..
// i) Insert
// ii) Retrieve
// iii) Delete
@Dao
interface ArticleDao {

    // Upsert: update + insert
    // Replace to replace the row when there is an identical article
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article): Long

    // Retrieve
    // will return a Live-Data object (cannot use 'suspend')
    // LD enables us to subscribe to it, and observe it to update the recycler-view
    // View-Model is not recreated when we rotate the device, so having the LD inside the Viewmodel
    // enables us to see the changes in responses immediately thereby updating the UI...
    @Query("SELECT * FROM articles")
    fun getAllArticles(): LiveData<List<Article>>

    // Delete
    // (ie. suspend b/c it is dealing with the local database)
    @Delete
    suspend fun deleteArticle(article: Article)
}