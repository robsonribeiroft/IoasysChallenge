package com.rrdev.presentation_enterprises

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.rrdev.base_presentation.*
import com.rrdev.base_presentation.mapper.EnterpriseMapper
import com.rrdev.base_presentation.model.EnterpriseBinding
import com.rrdev.domain.usecase.GetAllEnterprises
import com.rrdev.domain.usecase.GetEnterpriseByName
import org.koin.core.KoinComponent

class EnterprisesViewModel(
    app: Application
): AndroidViewModel(app), KoinComponent {

    private val getAllEnterprises: GetAllEnterprises by useCase()
    private val getEnterpriseByName: GetEnterpriseByName by useCase()

    private val _allEnterprisesViewState by viewState<List<EnterpriseBinding>>()
    private val _byNameEnterprisesViewState by viewState<List<EnterpriseBinding>>()

    val allEnterprisesViewState = _allEnterprisesViewState.asLiveData()
    val byNameEnterprisesViewState = _byNameEnterprisesViewState.asLiveData()

    fun fetchEnterprises(){
        _allEnterprisesViewState.postLoading()
        getAllEnterprises(
            onSuccess = { dataEnterprises ->
                when {
                    dataEnterprises.isSuccessFul() -> {
                        _allEnterprisesViewState.postSuccess(
                            dataEnterprises.data.map(EnterpriseMapper::toPresentation)
                        )
                    }
                    else -> {
                        _allEnterprisesViewState.postError(dataEnterprises.exception!!)
                    }
                }
            },
            onError = {
                _allEnterprisesViewState.postError(it)
            }
        )
    }

    fun fetchEnterpriseByName(enterpriseName: String){
        _byNameEnterprisesViewState.postLoading()
        getEnterpriseByName(
            params = GetEnterpriseByName.Params(
                searchForEnterprise = enterpriseName
            ),
            onSuccess = { enterprises ->
                _byNameEnterprisesViewState.postSuccess(
                    enterprises.map(EnterpriseMapper::toPresentation)
                )
            },
            onError = {
                _byNameEnterprisesViewState.postError(it)
            }
        )
    }
}