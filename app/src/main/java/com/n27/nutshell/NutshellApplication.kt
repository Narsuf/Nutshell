package com.n27.nutshell

import android.app.Application
import com.n27.nutshell.di.AppComponent
import com.n27.nutshell.di.DaggerAppComponent

class NutshellApplication : Application() {

    val appComponent: AppComponent = DaggerAppComponent.builder()
        .build()
}