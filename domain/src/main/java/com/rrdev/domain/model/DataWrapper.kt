package com.rrdev.domain.model

data class DataWrapper <T>(val data: T, val exception: Throwable? = null){

    fun isSuccessFul(): Boolean = exception == null
}
