package org.n27.nutshell.detail.presentation.entities

sealed class DetailAction {

    data object GetDetail : DetailAction()
    data object BackClicked : DetailAction()
    data object RetryClicked : DetailAction()
    data class InfoClicked(val url: String, val navScreen: String?) : DetailAction()
    data class NavItemClicked(val id: Int, val label: String) : DetailAction()
}
