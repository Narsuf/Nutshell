package com.n27.nutshell.presentation.topics.entities

sealed class TopicsEvent {

    data class GoToNextScreen(val key: String) : TopicsEvent()
}