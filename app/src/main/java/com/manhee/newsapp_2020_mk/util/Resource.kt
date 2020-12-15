package com.manhee.newsapp_2020_mk.ui

/**
 * 'sealed-class' is like 'enum'
 * which contains a group of CONSTANTS (ie. classes in this case)
 *
 * ★★★★★ This class is to wrap around network-responses
 * recommended by Google (Generic)
**/

sealed class Resource<T>(val data: T? = null, val message: String? = null) {

    // 'T' refers to the network-response (in this case)
    class Success<T>(data: T) : Resource<T>(data)

    // 'T' refers to the network-response (in this case)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)

    // 'T' refers to the network-response (in this case)
    class Loading<T> : Resource<T>()

}