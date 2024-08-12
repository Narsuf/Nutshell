package org.n27.nutshell.presentation.detail.mapping

import org.n27.nutshell.presentation.detail.entities.DetailUiState
import org.n27.nutshell.presentation.detail.entities.DetailUiState.HasContent
import org.n27.nutshell.presentation.detail.entities.DetailUiState.NoContent
import org.n27.nutshell.presentation.detail.entities.DetailViewModelState

fun DetailViewModelState.toUiState(): DetailUiState = if (nav != null && tab != null)
    HasContent(tab, nav, isLoading, error)
else
    NoContent(isLoading, error)