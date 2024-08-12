package org.n27.nutshell.presentation.topics.entities

import org.n27.nutshell.domain.topics.model.Topic
import org.n27.nutshell.presentation.common.model.Error as MyError

sealed class TopicsUiState {

    data object Loading : TopicsUiState()
    data class Content(val topics: List<Topic>) : TopicsUiState()
    data class Error(val error: MyError) : TopicsUiState()
}