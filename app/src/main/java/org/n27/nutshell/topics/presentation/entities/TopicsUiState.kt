package org.n27.nutshell.topics.presentation.entities

import kotlinx.collections.immutable.ImmutableList
import org.n27.nutshell.topics.domain.model.Topic
import org.n27.nutshell.common.presentation.model.Error as MyError

sealed class TopicsUiState {

    data object Loading : TopicsUiState()
    data class Content(val topics: ImmutableList<Topic>) : TopicsUiState()
    data class Error(val error: MyError) : TopicsUiState()
}
