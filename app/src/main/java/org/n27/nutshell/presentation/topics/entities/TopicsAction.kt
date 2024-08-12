package org.n27.nutshell.presentation.topics.entities

sealed class TopicsAction {

    data class NextButtonClicked(val key: String, val title: String) : TopicsAction()
}