package com.n27.nutshell.presentation.detail.entities

sealed class DetailAction {

    data class InfoClicked(val url: String) : DetailAction()
}