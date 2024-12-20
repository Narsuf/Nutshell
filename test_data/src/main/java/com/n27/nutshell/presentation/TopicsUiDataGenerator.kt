package com.n27.nutshell.presentation

import com.n27.nutshell.domain.getTopic
import kotlinx.collections.immutable.persistentListOf
import org.n27.nutshell.topics.presentation.entities.TopicsUiState.Content
import org.n27.nutshell.topics.presentation.entities.TopicsUiState.Error

fun getTopicsContent() = Content(
    topics = persistentListOf(getTopic())
)

fun getTopicsError() = Error(
    error = getError()
)
