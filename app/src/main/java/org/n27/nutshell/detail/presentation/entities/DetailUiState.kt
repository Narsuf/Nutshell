package org.n27.nutshell.detail.presentation.entities

import kotlinx.collections.immutable.ImmutableList
import org.n27.nutshell.common.presentation.model.Error
import org.n27.nutshell.detail.domain.model.Detail.NavItem
import org.n27.nutshell.detail.domain.model.Detail.Tab.Info

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
