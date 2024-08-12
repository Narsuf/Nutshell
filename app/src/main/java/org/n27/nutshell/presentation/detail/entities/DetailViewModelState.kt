package org.n27.nutshell.presentation.detail.entities

import org.n27.nutshell.domain.detail.model.Detail
import org.n27.nutshell.domain.detail.model.DetailNavItem
import org.n27.nutshell.presentation.common.model.Error

data class DetailViewModelState(
    val content: Detail? = null,
    val navItems: List<DetailNavItem> = emptyList(),
    val isLoading: Boolean = true,
    val error: Error? = null
)