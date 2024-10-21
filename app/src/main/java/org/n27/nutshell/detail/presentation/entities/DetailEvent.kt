package org.n27.nutshell.detail.presentation.entities

sealed class DetailEvent {

    data object GoBack : DetailEvent()
    data class OpenUrl(val url: String) : DetailEvent()
}
