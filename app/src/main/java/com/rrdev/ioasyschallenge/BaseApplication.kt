package com.rrdev.ioasyschallenge

import android.app.Application
import com.rrdev.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                listOf(
                    domainModule,
                    dataModule,
                    dataLocalModule,
                    dataRemoteModule,
                    intentModule,
                    presentationModule
                )
            )
        }.androidContext(applicationContext)
    }
}