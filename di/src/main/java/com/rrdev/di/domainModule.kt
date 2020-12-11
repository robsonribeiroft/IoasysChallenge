package com.rrdev.di

import com.rrdev.domain.usecase.GetAllEnterprises
import com.rrdev.domain.usecase.GetEnterpriseByName
import com.rrdev.domain.usecase.LogIn
import kotlinx.coroutines.CoroutineScope
import org.koin.dsl.module

val domainModule = module {
    factory { (scope: CoroutineScope)->
        GetAllEnterprises(scope, enterpriseRepository = get())
    }
    factory { (scope: CoroutineScope)->
        GetEnterpriseByName(scope, enterpriseRepository = get())
    }
    factory { (scope: CoroutineScope)->
        LogIn(scope, authenticationRepository = get())
    }
}