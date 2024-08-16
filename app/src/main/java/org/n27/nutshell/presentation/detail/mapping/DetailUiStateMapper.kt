package org.n27.nutshell.presentation.detail.mapping

import kotlinx.collections.immutable.toPersistentList
import org.n27.nutshell.domain.detail.model.Detail
import org.n27.nutshell.presentation.detail.entities.DetailUiState
import org.n27.nutshell.presentation.detail.entities.DetailUiState.HasContent
import org.n27.nutshell.presentation.detail.entities.DetailUiState.NoContent
import org.n27.nutshell.presentation.detail.entities.DetailViewModelState

fun DetailViewModelState.toUiState(): DetailUiState = if (nav != null && tab != null)
    HasContent(tab.toTabContent(), nav.toPersistentList(), isLoading, error)
else
    NoContent(isLoading, error)

private fun Detail.Tab.toTabContent() = HasContent.TabContent(
    infoList = infoList.toPersistentList(),
    sourceUrl = sourceUrl
)