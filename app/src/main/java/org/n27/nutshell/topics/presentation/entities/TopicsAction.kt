package org.n27.nutshell.topics.presentation.entities

sealed class TopicsAction {

    data object RetryButtonClicked : TopicsAction()
    data class NextButtonClicked(val key: String, val title: String) : TopicsAction()
}
