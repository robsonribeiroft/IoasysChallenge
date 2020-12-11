package com.rrdev.di

import androidx.appcompat.app.AppCompatActivity
import com.rrdev.feature_login.navigation.LoginNavigation
import com.rrdev.intent.LoginNavigationImpl
import org.koin.dsl.module

val intentModule = module {

    factory<LoginNavigation> { (activity: AppCompatActivity) ->
        LoginNavigationImpl(activity)
    }
}