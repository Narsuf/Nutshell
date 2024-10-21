package org.n27.nutshell.detail.presentation.entities

import org.n27.nutshell.common.presentation.model.Error
import org.n27.nutshell.detail.domain.model.Detail.NavItem
import org.n27.nutshell.detail.domain.model.Detail.Tab

data class DetailViewModelState(
    val tab: Tab? = null,
    val nav: List<NavItem>? = null,
    val isLoading: Boolean = true,
    val error: Error? = null
)
