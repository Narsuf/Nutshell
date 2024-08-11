package com.n27.nutshell.data.di

import android.app.Application
import com.google.firebase.database.FirebaseDatabase
import com.n27.nutshell.data.common.DataUtils
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    fun provideDataUtils(app: Application) = DataUtils(app)

    @Provides
    @Singleton
    fun provideFirebaseDatabase() = FirebaseDatabase.getInstance()
}