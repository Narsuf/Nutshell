package org.n27.nutshell.presentation.topics.entities

import org.n27.nutshell.domain.topics.model.Topic

sealed class TopicsUiState {

    data object Loading : TopicsUiState()
    data object Error : TopicsUiState()

    data class Content(val topics: List<Topic>) : TopicsUiState() {

        data class Card(
            val title: String,
            val imageUrl: String,
            val key: String
        )
    }
}