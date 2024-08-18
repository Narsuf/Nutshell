package com.n27.nutshell.presentation

import com.n27.nutshell.domain.getInfo
import com.n27.nutshell.domain.getNavs
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toPersistentList
import org.n27.nutshell.domain.detail.model.Detail.NavItem
import org.n27.nutshell.domain.detail.model.Detail.Tab.Info
import org.n27.nutshell.presentation.common.model.Error
import org.n27.nutshell.presentation.detail.entities.DetailUiState.HasContent
import org.n27.nutshell.presentation.detail.entities.DetailUiState.HasContent.TabContent
import org.n27.nutshell.presentation.detail.entities.DetailUiState.NoContent

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
