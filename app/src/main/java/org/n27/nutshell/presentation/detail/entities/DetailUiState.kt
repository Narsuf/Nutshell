package org.n27.nutshell.presentation.detail.entities

import kotlinx.collections.immutable.ImmutableList
import org.n27.nutshell.domain.detail.model.Detail.NavItem
import org.n27.nutshell.domain.detail.model.Detail.Tab.Info
import org.n27.nutshell.presentation.common.model.Error

sealed class DetailUiState {

    data class NoContent(
        val isLoading: Boolean,
        val error: Error?
    ) : DetailUiState()

    data class HasContent(
        val tab: TabContent,
        val nav: ImmutableList<NavItem>
    ) : DetailUiState() {

        data class TabContent(
            val infoList: ImmutableList<Info>,
            val sourceUrl: String
        )
    }
}