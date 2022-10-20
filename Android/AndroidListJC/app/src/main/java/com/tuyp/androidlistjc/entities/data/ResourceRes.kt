package com.tuyp.androidlistjc.entities.data

import java.lang.Exception

sealed class ResponseResource<out T> {
    object Loading: ResponseResource<Nothing>()

    data class Success<out T> (
        val data: T?
    ): ResponseResource<T>()

    data class Failure(val e: Exception?): ResponseResource<Nothing>()
}