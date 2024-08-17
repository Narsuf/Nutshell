package org.n27.nutshell.presentation.detail.entities

import org.n27.nutshell.domain.detail.model.Detail.NavItem
import org.n27.nutshell.domain.detail.model.Detail.Tab
import org.n27.nutshell.presentation.common.model.Error

data class DetailViewModelState(
    val tab: Tab? = null,
    val nav: List<NavItem>? = null,
    val isLoading: Boolean = true,
    val error: Error? = null
)