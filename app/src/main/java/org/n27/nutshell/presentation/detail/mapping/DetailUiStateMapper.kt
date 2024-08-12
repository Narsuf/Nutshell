package org.n27.nutshell.presentation.detail.mapping

import org.n27.nutshell.presentation.detail.entities.DetailUiState
import org.n27.nutshell.presentation.detail.entities.DetailUiState.HasNavItems
import org.n27.nutshell.presentation.detail.entities.DetailUiState.NoNavItems
import org.n27.nutshell.presentation.detail.entities.DetailViewModelState

fun DetailViewModelState.toUiState(): DetailUiState = if (navItems.isNotEmpty())
    HasNavItems(content, navItems, isLoading, error)
else
    NoNavItems(isLoading, error)