package com.n27.nutshell.presentation.detail.entities

sealed class DetailUiState {

    data class Content(
        val infoList: List<Info>,
        val navItems: List<NavItem>
    ) : DetailUiState() {

        data class Info(
            val iconUrl: String,
            val text: String,
            val value: String
        )

        data class NavItem(
            val iconUrl: String,
            val label: String
        )
    }
}