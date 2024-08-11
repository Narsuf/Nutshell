package com.n27.nutshell.presentation.detail.entities

sealed class DetailUiState {

    data class Content(val navItems: List<NavItem>) : DetailUiState() {

        data class NavItem(
            val content: String,
            val iconUrl: String,
            val label: String
        )
    }
}