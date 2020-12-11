package com.rrdev.presentation_splashscreen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.rrdev.base_presentation.*
import com.rrdev.base_presentation.mapper.EnterpriseMapper
import com.rrdev.base_presentation.model.EnterpriseBinding
import com.rrdev.domain.usecase.GetAllEnterprises
import org.koin.core.KoinComponent

class SplashScreenViewModel(
    app: Application
): AndroidViewModel(app), KoinComponent {

    private val getAllEnterprises: GetAllEnterprises by useCase()

    private val _allEnterprisesViewState by viewState<List<EnterpriseBinding>>()

    val allEnterprisesViewState = _allEnterprisesViewState.asLiveData()

    fun fetchEnterprises(){
        _allEnterprisesViewState.postLoading()
        getAllEnterprises(
            onSuccess = { enterprises ->
                _allEnterprisesViewState.postSuccess(
                    enterprises.map(EnterpriseMapper::toPresentation)
                )
            },
            onError = {
                _allEnterprisesViewState.postError(it)
            }
        )
    }
}