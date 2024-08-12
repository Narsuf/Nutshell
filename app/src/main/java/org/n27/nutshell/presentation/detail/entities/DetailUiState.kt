package org.n27.nutshell.presentation.detail.entities

import org.n27.nutshell.domain.detail.model.Detail
import org.n27.nutshell.domain.detail.model.DetailNavItem
import org.n27.nutshell.presentation.common.model.Error

sealed interface DetailUiState {

    val isLoading: Boolean
    val error: Error?

    data class NoNavItems(
        override val isLoading: Boolean,
        override val error: Error?
    ) : DetailUiState

    data class HasNavItems(
        val content: Detail?,
        val navItems: List<DetailNavItem>,
        override val isLoading: Boolean,
        override val error: Error?
    ) : DetailUiState
}