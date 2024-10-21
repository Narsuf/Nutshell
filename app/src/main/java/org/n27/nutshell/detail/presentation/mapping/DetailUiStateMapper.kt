package org.n27.nutshell.detail.presentation.mapping

import kotlinx.collections.immutable.toPersistentList
import org.n27.nutshell.detail.domain.model.Detail
import org.n27.nutshell.detail.presentation.entities.DetailUiState
import org.n27.nutshell.detail.presentation.entities.DetailUiState.HasContent
import org.n27.nutshell.detail.presentation.entities.DetailUiState.NoContent
import org.n27.nutshell.detail.presentation.entities.DetailViewModelState

fun DetailViewModelState.toUiState(): DetailUiState = if (nav != null && tab != null)
    HasContent(tab.toTabContent(), nav.toPersistentList())
else
    NoContent(isLoading, error)

private fun Detail.Tab.toTabContent() = HasContent.TabContent(
    infoList = infoList.toPersistentList(),
    sourceUrl = sourceUrl
)
