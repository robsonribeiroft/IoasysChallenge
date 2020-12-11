package com.rrdev.domain.usecase

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import java.lang.Exception

abstract class UseCase<T, in Params>(private val scope: CoroutineScope) {

    abstract fun run(params: Params? = null): Flow<T>

    operator fun invoke(
            params: Params? = null,
            onSuccess: (T) -> Unit = {},
            onError: (Throwable) -> Unit = {},
            runDispatcher: CoroutineDispatcher = Dispatchers.IO,
            watchDispatcher: CoroutineDispatcher = Dispatchers.Main
    ){
        scope.launch(runDispatcher) {
            try {
                run(params).collect {
                    withContext(watchDispatcher){
                        onSuccess(it)
                    }
                }
            }catch (e: Exception) {
                withContext(watchDispatcher){
                    onError(e)
                }
            }
        }
    }

    fun cancel(scope: CoroutineScope) = scope.coroutineContext.cancelChildren()
}