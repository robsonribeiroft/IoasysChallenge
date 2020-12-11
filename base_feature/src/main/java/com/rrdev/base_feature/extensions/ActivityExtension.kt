package com.rrdev.base_feature.extensions

import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.snackbar.Snackbar
import com.rrdev.base_feature.R

fun AppCompatActivity.setToolbar(
    toolbar: Toolbar,
    navigationUp: Boolean = false,
    title: String? = null
){
    setSupportActionBar(toolbar)
    supportActionBar?.apply {
        setDisplayHomeAsUpEnabled(navigationUp)
        setDisplayShowHomeEnabled(navigationUp)
        title?.let { this.title = it }
    }
}

fun AppCompatActivity.showSnack(view: View, message: String, action: () -> Unit = {}){
    val snackbar = Snackbar
        .make(view, message, Snackbar.LENGTH_LONG)
        .setAction(getString(R.string.try_again)) { action() }
    (snackbar.view.findViewById(com.google.android.material.R.id.snackbar_text) as TextView).maxLines = 10
    snackbar.show()
}