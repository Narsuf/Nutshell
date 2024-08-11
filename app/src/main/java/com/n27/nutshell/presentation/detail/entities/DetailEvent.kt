package com.n27.nutshell.presentation.detail.entities

sealed class DetailEvent {

    data class OpenUrl(val url: String) : DetailEvent()
}