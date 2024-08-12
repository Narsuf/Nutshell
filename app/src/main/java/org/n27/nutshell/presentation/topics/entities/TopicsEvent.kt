package org.n27.nutshell.presentation.topics.entities

sealed class TopicsEvent {

    data class GoToNextScreen(val key: String, val title: String) : TopicsEvent()
}