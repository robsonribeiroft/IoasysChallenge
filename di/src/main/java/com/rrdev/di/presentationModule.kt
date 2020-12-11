package com.rrdev.di

import com.rrdev.presentation_enterprises.EnterprisesViewModel
import com.rrdev.presentation_login.LogInViewModel
import com.rrdev.presentation_splashscreen.SplashScreenViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { LogInViewModel(androidApplication()) }
    viewModel { EnterprisesViewModel(androidApplication()) }
    viewModel { SplashScreenViewModel(androidApplication()) }
}