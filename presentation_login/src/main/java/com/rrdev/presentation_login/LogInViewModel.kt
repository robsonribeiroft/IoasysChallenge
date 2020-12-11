package com.rrdev.presentation_login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.rrdev.base_presentation.*
import com.rrdev.domain.usecase.LogIn
import org.koin.core.KoinComponent

class LogInViewModel(
    app: Application
): AndroidViewModel(app), KoinComponent {

    private val logIn: LogIn by useCase()

    private val _logInViewState by viewState<Unit>()

    val logInViewState = _logInViewState.asLiveData()

    fun authUser(email: String, password: String){
        _logInViewState.postLoading()
        logIn(params = LogIn.Params(
            email = email,
            password = password
        ),
        onSuccess = {
            _logInViewState.postSuccess(Unit)
        },
        onError = {
            _logInViewState.postError(it)
        })
    }
}