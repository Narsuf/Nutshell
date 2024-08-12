package org.n27.nutshell.presentation.detail.entities

sealed class DetailAction {

    data class GetNavIcons(val key: String) : DetailAction()
    data class InfoClicked(val url: String) : DetailAction()
}