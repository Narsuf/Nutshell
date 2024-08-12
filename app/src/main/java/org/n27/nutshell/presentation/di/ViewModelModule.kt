package org.n27.nutshell.presentation.di

import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import org.n27.nutshell.presentation.detail.DetailViewModel
import org.n27.nutshell.presentation.detail.DetailViewModelFactory

@Module
class ViewModelModule {

    @Provides
    fun provideDetailViewModelFactory(
        factory: DetailViewModel.Factory,
        key: String
    ): ViewModelProvider.Factory = DetailViewModelFactory(factory, key)
}