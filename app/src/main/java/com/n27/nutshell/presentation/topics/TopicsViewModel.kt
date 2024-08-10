package com.n27.nutshell.presentation.topics

import androidx.lifecycle.ViewModel
import com.n27.nutshell.presentation.topics.entities.TopicsEvent
import com.n27.nutshell.presentation.topics.entities.TopicsEvent.GoToNextScreen
import com.n27.nutshell.presentation.topics.entities.TopicsAction
import com.n27.nutshell.presentation.topics.entities.TopicsAction.NextButtonClicked
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject

class TopicsViewModel @Inject constructor() : ViewModel() {

    private val event = Channel<TopicsEvent>(capacity = 1, BufferOverflow.DROP_OLDEST)
    val viewEvent = event.receiveAsFlow()

    fun handleAction(action: TopicsAction) = when (action) {
        NextButtonClicked -> event.trySend(GoToNextScreen)
    }
}