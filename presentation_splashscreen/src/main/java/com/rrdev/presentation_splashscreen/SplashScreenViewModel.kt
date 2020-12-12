package com.rrdev.presentation_splashscreen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.rrdev.base_presentation.*
import com.rrdev.domain.usecase.GetAllEnterprises
import org.koin.core.KoinComponent

class SplashScreenViewModel(
    app: Application
): AndroidViewModel(app), KoinComponent {

    private val getAllEnterprises: GetAllEnterprises by useCase()

    private val _allEnterprisesViewState by viewState<Unit>()

    val allEnterprisesViewState = _allEnterprisesViewState.asLiveData()

    fun fetchEnterprises(){
        _allEnterprisesViewState.postLoading()
        getAllEnterprises(
            onSuccess = { dataEnterprises ->
                when {
                    dataEnterprises.isSuccessFul() -> _allEnterprisesViewState.postSuccess(Unit)
                    else -> _allEnterprisesViewState.postError(dataEnterprises.exception!!)
                }
            },
            onError = {
                _allEnterprisesViewState.postError(it)
            }
        )
    }
}