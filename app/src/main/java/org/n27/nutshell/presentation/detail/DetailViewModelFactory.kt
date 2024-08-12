package org.n27.nutshell.presentation.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class DetailViewModelFactory(
    private val assistedFactory: DetailViewModel.Factory,
    private val key: String
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T = assistedFactory.create(key) as T
}