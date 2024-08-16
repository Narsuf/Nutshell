package org.n27.nutshell.presentation.detail.entities

import kotlinx.collections.immutable.ImmutableList
import org.n27.nutshell.domain.detail.model.Detail.DetailNavItem
import org.n27.nutshell.domain.detail.model.Detail.Tab.Info
import org.n27.nutshell.presentation.common.model.Error

sealed interface DetailUiState {

    val isLoading: Boolean
    val error: Error?

    data class NoContent(
        override val isLoading: Boolean,
        override val error: Error?
    ) : DetailUiState

    data class HasContent(
        val tab: TabContent,
        val nav: ImmutableList<DetailNavItem>,
        override val isLoading: Boolean,
        override val error: Error?
    ) : DetailUiState {

        data class TabContent(
            val infoList: ImmutableList<Info>,
            val sourceUrl: String
        )
    }
}