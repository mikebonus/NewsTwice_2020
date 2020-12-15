package com.manhee.newsapp_2020_mk.repository

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.manhee.newsapp_2020_mk.NewsApplication
import com.manhee.newsapp_2020_mk.MainActivity
import com.manhee.newsapp_2020_mk.ui.Article
import com.manhee.newsapp_2020_mk.NewsActivity
import com.manhee.newsapp_2020_mk.ui.Constants.Companion.STT_REFRESHER
import com.manhee.newsapp_2020_mk.ui.NewsResponse
import com.manhee.newsapp_2020_mk.ui.Resource
import kotlinx.coroutines.launch
import retrofit2.Response
import java.io.IOException

/**
 * By default, constructor-param on view-models cannot be done
 * So to do that, we need to create 'ViewModelProviderFactory'
 * to pass 'Repository' in the constructor */
class NewsViewModel(
    app: Application,
    val newsRepository: NewsRepository
) : AndroidViewModel(app) {

    // Breaking-News
    val breakingNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    var breakingNewsPage = 1       // for pagination
    var breakingNewsResponse: NewsResponse? = null

    // Search-News
    val searchNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    var searchNewsPage = 1       // for pagination
    var searchNewsResponse: NewsResponse? = null


    // 1 - America - us
    // 2 - Australia - AU
    // 3 - brazil - BR
    // 4 - canada - CA
    // 5 - france - FR
    // 6 - germany - DE
    // 7 - great britain - GB
    // 8 - india - IN
    // 9 - israel - IL
    // 10 - italy - IT
    // 11 - japan - JP
    // 12 - korea - KR
    // 13 - russia - ru
    // 14 - South Africa - za
    // 15 - turkey - TR


    init {

        // 1 - America - us
        if (MainActivity.Flagger.FLAG == "us"
            || MainActivity.Flagger.output == "United States"
            || MainActivity.Flagger.output == "United States of America"
            || MainActivity.Flagger.output == "the United States of America"
            || MainActivity.Flagger.output == "USA"
            || MainActivity.Flagger.output == "the USA"
            || MainActivity.Flagger.output == "u.s."
            || MainActivity.Flagger.output == "us"
            || MainActivity.Flagger.output == "U.S."
            || MainActivity.Flagger.output == "US"
            || MainActivity.Flagger.output == "the US"
            || MainActivity.Flagger.output == "America"
            || MainActivity.Flagger.output == "the America"
        ) {
            getBreakingNews("us")
            MainActivity.Flagger.output =
                STT_REFRESHER          // custom-logic for VTT-refresher reasons (sweden is at the end of the list)

            // 2 - Australia - AU
        } else if (MainActivity.Flagger.FLAG == "au"
            || MainActivity.Flagger.output == "Australia"
        ) {
            getBreakingNews("au")
            MainActivity.Flagger.output =
                STT_REFRESHER         // custom-logic for VTT-refresher reasons (sweden is at the end of the list)

            // 3 - brazil - BR
        } else if (MainActivity.Flagger.FLAG == "br"
            || MainActivity.Flagger.output == "Brazil"
        ) {
            getBreakingNews("br")
            MainActivity.Flagger.output =
                STT_REFRESHER        // custom-logic for VTT-refresher reasons (sweden is at the end of the list)

            // 4 - canada - CA
        } else if (MainActivity.Flagger.FLAG == "ca"
            || MainActivity.Flagger.output == "Canada"
        ) {
            getBreakingNews("ca")
            MainActivity.Flagger.output =
                STT_REFRESHER       // custom-logic for VTT-refresher reasons (sweden is at the end of the list)

            // 5 - france - FR
        } else if (MainActivity.Flagger.FLAG == "fr"
            || MainActivity.Flagger.output == "France"
        ) {
            getBreakingNews("fr")
            MainActivity.Flagger.output =
                STT_REFRESHER       // custom-logic for VTT-refresher reasons (sweden is at the end of the list)

            // 6 - germany - DE
        } else if (MainActivity.Flagger.FLAG == "de"
            || MainActivity.Flagger.output == "Germany"
        ) {
            getBreakingNews("de")
            MainActivity.Flagger.output =
                STT_REFRESHER       // custom-logic for VTT-refresher reasons (sweden is at the end of the list)

            // 7 - great britain - GB
        } else if (MainActivity.Flagger.FLAG == "gb"
            || MainActivity.Flagger.output == "England"
            || MainActivity.Flagger.output == "UK"
            || MainActivity.Flagger.output == "the UK"
            || MainActivity.Flagger.output == "United Kingdom"
            || MainActivity.Flagger.output == "the United Kingdom"
            || MainActivity.Flagger.output == "Great Britain"
            || MainActivity.Flagger.output == "the Great Britain"
        ) {
            getBreakingNews("gb")
            MainActivity.Flagger.output =
                STT_REFRESHER       // custom-logic for VTT-refresher reasons (sweden is at the end of the list)

            // 8 - india - IN
        } else if (MainActivity.Flagger.FLAG == "in"
            || MainActivity.Flagger.output == "India"
        ) {
            getBreakingNews("in")
            MainActivity.Flagger.output =
                STT_REFRESHER       // custom-logic for VTT-refresher reasons (sweden is at the end of the list)

            // 9 - israel - IL
        } else if (MainActivity.Flagger.FLAG == "il"
            || MainActivity.Flagger.output == "Israel"
        ) {
            getBreakingNews("il")
            MainActivity.Flagger.output =
                STT_REFRESHER      // custom-logic for VTT-refresher reasons (sweden is at the end of the list)

            // 10 - italy - IT
        } else if (MainActivity.Flagger.FLAG == "it"
            || MainActivity.Flagger.output == "Italy"
        ) {
            getBreakingNews("it")
            MainActivity.Flagger.output =
                STT_REFRESHER       // custom-logic for VTT-refresher reasons (sweden is at the end of the list)

            // 11 - Japan - jp
        } else if (MainActivity.Flagger.FLAG == "jp"
            || MainActivity.Flagger.output == "Japan"
        ) {
            getBreakingNews("jp")
            MainActivity.Flagger.output =
                STT_REFRESHER       // custom-logic for VTT-refresher reasons (sweden is at the end of the list)

            // 12 - korea - KR
        } else if (MainActivity.Flagger.FLAG == "kr"
            || MainActivity.Flagger.output == "Korea"
            || MainActivity.Flagger.output == "Korea Republic"
            || MainActivity.Flagger.output == "South Korea"
        ) {
            getBreakingNews("kr")
            MainActivity.Flagger.output =
                STT_REFRESHER       // custom-logic for VTT-refresher reasons (sweden is at the end of the list)

            // 13 - russia - ru
        } else if (MainActivity.Flagger.FLAG == "ru"
            || MainActivity.Flagger.output == "Russia"
        ) {
            getBreakingNews("ru")
            MainActivity.Flagger.output =
                STT_REFRESHER       // custom-logic for VTT-refresher reasons (sweden is at the end of the list)

            // 14 - South Africa - za
        } else if (MainActivity.Flagger.FLAG == "za"
            || MainActivity.Flagger.output == "South Africa"
        ) {
            getBreakingNews("za")
            MainActivity.Flagger.output =
                STT_REFRESHER       // custom-logic for VTT-refresher reasons (sweden is at the end of the list)

            // 15 - sweden - SE...
        } else if (MainActivity.Flagger.FLAG == "se"
            || MainActivity.Flagger.output == "Sweden"
        ) {
            getBreakingNews("se")
            MainActivity.Flagger.output =
                STT_REFRESHER       // custom-logic for VTT-refresher reasons (sweden is at the end of the list)
        }
    }

    // ★★★★★ Key-Function:
    // viewModelScope is alive as long as your view-model is alive...
    fun getBreakingNews(countryCode: String) = viewModelScope.launch {
        safeBreakingNewsCall(countryCode)
    }

    // very similar to 'getBreakingNews()' above
    fun searchNews(searchQuery: String) = viewModelScope.launch {
        safeSearchNewsCall(searchQuery)
    }


    private fun handleBreakingNewsResponse(response: Response<NewsResponse>): Resource<NewsResponse> {
        // returns 'Resource<NewsRespoinse>'...

        // CASE 1:
        if (response.isSuccessful) {
            response.body()?.let {
                    resultResponse ->

                // we want to increase the page number...
                // for loading the next-page while
                // initing 'breakingNewsResponse which was null

                breakingNewsPage++

                // if first-page....
                if (breakingNewsResponse == null) {
                    breakingNewsResponse = resultResponse // resultResponse

                // if more than one-page...
                } else {
//                    breakingNewsResponse = resultResponse

//                    val oldArticles = breakingNewsResponse?.articles
//                    val newArticles = resultResponse.articles
//                    oldArticles?.addAll(newArticles)
                }

                return Resource.Success(
                    breakingNewsResponse?: resultResponse
                )     // returns the Success-state
            }
        }

        // Otherwise
        return Resource.Error(response.message())
    }


    // Almost same as above method
    private fun handleSearchNewsResponse(response: Response<NewsResponse>): Resource<NewsResponse> {

        // CASE 1:
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->

                searchNewsPage++

                // if first-page....
                if (searchNewsResponse == null) {
                    searchNewsResponse = resultResponse

                    // if more than one-page...
                } else {
                    val oldArticles = searchNewsResponse?.articles
                    val newArticles = resultResponse.articles
                    oldArticles?.clear()
                    oldArticles?.addAll(newArticles)
                }

                return Resource.Success(
                    searchNewsResponse ?: resultResponse
                )     // returns the Success-state
            }
        }

        // Otherwise
        return Resource.Error(response.message())
    }

    // DB-Operation #1: Save-Operation
    fun saveArticle(article: Article) = viewModelScope.launch {
        newsRepository.upsert(article)
    }

    // DB-Operation #2: Retrieve-Operation (No Coroutine needed)
    fun getSavedNews() = newsRepository.getSavedNews()

    // DB-Operation #3: Delete-Operation (Called in the SavedNewsFragment)
    fun deleteArticle(article: Article) = viewModelScope.launch {
        newsRepository.deleteArticle(article)
    }

    // Almost same as 'searchNewscall()'
    private suspend fun safeBreakingNewsCall(countryCode: String) {

        // currently-loading
        breakingNews.postValue(Resource.Loading())
        try {
            if (hasInternetConnection()) {
                val response = newsRepository.getBreakingNews(countryCode, breakingNewsPage)
                breakingNews.postValue(handleBreakingNewsResponse(response))

            } else {
                breakingNews.postValue(Resource.Error("No internet connection"))
            }

            // if getBreakingNews() has the error...
        } catch (t: Throwable) {

            when (t) {
                is IOException -> breakingNews.postValue(Resource.Error("Network Failure"))
                else -> breakingNews.postValue(Resource.Error("Conversion Error"))
            }
        }
    }

    // Almost same as 'breakingNewscall()'
    private suspend fun safeSearchNewsCall(searchQuery: String) {
        searchNews.postValue(Resource.Loading())
        try {
            if (hasInternetConnection()) {
                val response = newsRepository.searchNews(searchQuery, searchNewsPage)
                searchNews.postValue(handleSearchNewsResponse(response))

            } else {
                searchNews.postValue(Resource.Error("No internet connection"))
            }
        } catch (t: Throwable) {
            when (t) {
                is IOException -> searchNews.postValue(Resource.Error("Network Failure"))
                else -> searchNews.postValue(Resource.Error("Conversion Error"))
            }
        }
    }


    // for checking internet-connection...
    private fun hasInternetConnection(): Boolean {

        // getApplication() is only available in AndroidViewModel...
        val connectivityManager =
            getApplication<NewsApplication>()
                .getSystemService(
                    Context.CONNECTIVITY_SERVICE
                ) as ConnectivityManager

        // CASE 1: Version check (if higher than M)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val activeNetwork =
                connectivityManager.activeNetwork ?: return false       // if null...
            val capabilities = connectivityManager.getNetworkCapabilities(activeNetwork)
                ?: return false    // return flase b/c we don't have internet connection

            // various kinds of internet-connection
            return when {
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                else -> false
            }

            // CASE 2: Version check (if higher than M)
        } else {
            connectivityManager.activeNetworkInfo?.run {
                return when (type) {
                    ConnectivityManager.TYPE_WIFI -> true
                    ConnectivityManager.TYPE_MOBILE -> true
                    ConnectivityManager.TYPE_ETHERNET -> true
                    else -> false
                }
            }
        }
        return false
    }


}






