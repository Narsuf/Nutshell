package org.n27.nutshell

import android.app.Application
import org.n27.nutshell.di.AppComponent
import org.n27.nutshell.di.AppModule
import org.n27.nutshell.di.DaggerAppComponent

class NutshellApplication : Application() {

    val appComponent: AppComponent = DaggerAppComponent.builder()
        .appModule(AppModule(this))
        .build()
}