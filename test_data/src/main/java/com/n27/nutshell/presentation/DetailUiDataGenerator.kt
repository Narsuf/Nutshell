package com.n27.nutshell.presentation

import com.n27.nutshell.domain.getInfo
import com.n27.nutshell.domain.getNav
import kotlinx.collections.immutable.toPersistentList
import org.n27.nutshell.presentation.common.model.Error
import org.n27.nutshell.presentation.detail.entities.DetailUiState.HasContent
import org.n27.nutshell.presentation.detail.entities.DetailUiState.HasContent.TabContent
import org.n27.nutshell.presentation.detail.entities.DetailUiState.NoContent

fun getHasContent() = HasContent(
    tab = getTabContent(),
    nav = getNavContent()
)

fun getTabContent() = TabContent(
    infoList = listOf(getInfo()).toPersistentList(),
    sourceUrl = "http://fake.source.url.com"
)

fun getNavContent() = listOf(getNav()).toPersistentList()

fun getNoContent(
    isLoading: Boolean = true,
    error: Error? = null
) = NoContent(
    isLoading = isLoading,
    error = error
)
