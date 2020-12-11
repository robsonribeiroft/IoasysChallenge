package com.rrdev.base_feature

import androidx.appcompat.app.AppCompatActivity
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

inline fun <F : AppCompatActivity, reified V : Any> F.navigationIntent() = inject<V> {
    parametersOf(this)
}
