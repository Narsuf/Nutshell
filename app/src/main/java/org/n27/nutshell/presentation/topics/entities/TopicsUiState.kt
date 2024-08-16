package org.n27.nutshell.presentation.topics.entities

import kotlinx.collections.immutable.ImmutableList
import org.n27.nutshell.domain.topics.model.Topic
import org.n27.nutshell.presentation.common.model.Error as MyError

sealed class TopicsUiState {

    data object Loading : TopicsUiState()
    data class Content(val topics: ImmutableList<Topic>) : TopicsUiState()
    data class Error(val error: MyError) : TopicsUiState()
}