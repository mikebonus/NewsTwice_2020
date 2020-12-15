package com.manhee.newsapp_2020_mk.ui

import com.manhee.newsapp_2020_mk.ui.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/** This interface contains two methods to interact with the REST-API.
 * 'suspend' methods to do the operation on a background thread. **/

// LINK: http://newsapi.org/v2/everything?q=bitcoin&from=2020-06-23&sortBy=publishedAt&apiKey=1e31f11391514a5cbe137a05b26b051f
interface NewsAPI {

    // Method #1:
    @GET("v2/top-headlines")
    suspend fun getBreakingNews(

        // Two-letter country-code
        @Query("country")
        countryCode: String = "us",

        // for pagination...
        @Query("page")
        pageNumber: Int = 1,

        // so that news-api knows who is making this request...
        // the api-key is free..
        @Query("apiKey")
        apiKey: String = API_KEY

    ): Response<NewsResponse>

    // Method #2: searching needs 'everything'...
    @GET("v2/everything")
    suspend fun searchForNews(

        @Query("q")
        searchQuery: String,

        @Query("page")
        pageNumber: Int = 1,

        // so that news-api knows who is making this request...
        // the api-key is free
        @Query("apiKey")
        apiKey: String = API_KEY
    ): Response<NewsResponse>
}