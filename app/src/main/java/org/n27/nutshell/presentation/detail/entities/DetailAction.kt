package org.n27.nutshell.presentation.detail.entities

sealed class DetailAction {

    data object GetNavIcons : DetailAction()
    data object BackClicked : DetailAction()
    data class InfoClicked(val url: String) : DetailAction()
    data class NavItemClicked(val id: String) : DetailAction()
}