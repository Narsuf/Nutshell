package org.n27.nutshell.presentation.detail.entities

import org.n27.nutshell.domain.detail.model.Detail
import org.n27.nutshell.domain.detail.model.DetailNavItem

sealed interface DetailUiState {

    val isLoading: Boolean
    val error: String?

    data class NoNavItems(
        override val isLoading: Boolean,
        override val error: String?
    ) : DetailUiState

    data class HasNavItems(
        val content: Detail?,
        val navItems: List<DetailNavItem>,
        override val isLoading: Boolean,
        override val error: String?
    ) : DetailUiState
}