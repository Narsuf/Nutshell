package org.n27.nutshell.presentation.topics

import androidx.lifecycle.ViewModel
import org.n27.nutshell.presentation.topics.entities.TopicsEvent
import org.n27.nutshell.presentation.topics.entities.TopicsEvent.GoToNextScreen
import org.n27.nutshell.presentation.topics.entities.TopicsAction
import org.n27.nutshell.presentation.topics.entities.TopicsAction.NextButtonClicked
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject

class TopicsViewModel @Inject constructor() : ViewModel() {

    private val event = Channel<TopicsEvent>(capacity = 1, BufferOverflow.DROP_OLDEST)
    val viewEvent = event.receiveAsFlow()

    fun handleAction(action: TopicsAction) = when (action) {
        is NextButtonClicked -> event.trySend(GoToNextScreen(action.key))
    }
}