package com.androiddevs.mvvmnewsapp.api

import com.manhee.newsapp_2020_mk.ui.Constants.Companion.BASE_URL
import com.manhee.newsapp_2020_mk.ui.NewsAPI
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/** To create a Retrofit-instance whenever we are making a network-request */
class RetrofitInstance {

    companion object {

        // by lazy means everything inside this block will get
        // initialized ONLY once!
        private val retrofit by lazy {

            // log-responses to retrofit (external library) - useful for debugging
            // attach this to Retrofit to see request-info
            // (ie. which request are we making and what is the response?)
            // (ie. we get to see the BODY of the response)..
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)

            // we use interceptor to create this network-client
            val client = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()

            // Retrofit-instance
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())     // how to response should be interpreted into Kotlin-obj..
                .client(client)
                .build()
        }

        // by lazy means 'what's inside the curly-bracket' will be initialized only once!
        val api by lazy {
            retrofit.create(NewsAPI::class.java)
        }
    }







}