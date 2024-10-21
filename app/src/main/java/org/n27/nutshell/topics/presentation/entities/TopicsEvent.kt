package org.n27.nutshell.topics.presentation.entities

sealed class TopicsEvent {

    data class GoToNextScreen(val key: String, val title: String) : TopicsEvent()
}
