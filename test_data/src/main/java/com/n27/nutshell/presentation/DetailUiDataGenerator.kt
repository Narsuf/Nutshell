package com.n27.nutshell.presentation

import com.n27.nutshell.domain.getInfo
import com.n27.nutshell.domain.getNavs
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toPersistentList
import org.n27.nutshell.common.presentation.model.Error
import org.n27.nutshell.detail.domain.model.Detail.NavItem
import org.n27.nutshell.detail.domain.model.Detail.Tab.Info
import org.n27.nutshell.detail.presentation.entities.DetailUiState.HasContent
import org.n27.nutshell.detail.presentation.entities.DetailUiState.HasContent.TabContent
import org.n27.nutshell.detail.presentation.entities.DetailUiState.NoContent

fun getHasContent(
    info: Info = getInfo(),
    nav: ImmutableList<NavItem> = getNavContent()
) = HasContent(
    tab = getTabContent(info),
    nav = nav
)

fun getTabContent(info: Info) = TabContent(
    infoList = listOf(info).toPersistentList(),
    sourceUrl = "http://fake.source.url.com"
)

fun getNavContent() = getNavs().toPersistentList()

fun getNoContent(
    isLoading: Boolean = true,
    error: Error? = null
) = NoContent(
    isLoading = isLoading,
    error = error
)
