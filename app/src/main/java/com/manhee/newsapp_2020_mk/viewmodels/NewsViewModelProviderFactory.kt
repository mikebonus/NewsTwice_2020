package com.manhee.newsapp_2020_mk.repository

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * 'View-Model Provider Factory' is to allow passing Repository
 * in the parameter of the View-model constructor//
**/
class NewsViewModelProviderFactory(
    val app: Application,
    val newsRepository: NewsRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsViewModel(app, newsRepository) as T          // Typecasting to 'T'...
    }

}