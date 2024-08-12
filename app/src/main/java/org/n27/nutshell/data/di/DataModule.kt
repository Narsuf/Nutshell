package org.n27.nutshell.data.di

import android.app.Application
import com.google.firebase.database.FirebaseDatabase
import dagger.Module
import dagger.Provides
import org.n27.nutshell.data.common.DataUtils
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