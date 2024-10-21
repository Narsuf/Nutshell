package org.n27.nutshell.detail.presentation.di

import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import org.n27.nutshell.detail.presentation.DetailViewModel
import org.n27.nutshell.detail.presentation.DetailViewModelFactory

@Module
class ViewModelModule {

    @Provides
    fun provideDetailViewModelFactory(
        factory: DetailViewModel.Factory,
        key: String
    ): ViewModelProvider.Factory = DetailViewModelFactory(factory, key)
}
