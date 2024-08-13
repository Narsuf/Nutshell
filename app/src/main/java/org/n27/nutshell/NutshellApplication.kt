package org.n27.nutshell

import android.app.Application
import com.google.firebase.FirebaseApp
import org.n27.nutshell.di.AppComponent
import org.n27.nutshell.di.AppModule
import org.n27.nutshell.di.DaggerAppComponent

class NutshellApplication : Application() {

    val appComponent: AppComponent = DaggerAppComponent.builder()
        .appModule(AppModule(this))
        .build()

    override fun onCreate() {
        FirebaseApp.initializeApp(this)
        super.onCreate()
    }
}