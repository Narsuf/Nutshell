package org.n27.nutshell.presentation.topics

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import org.n27.nutshell.data.NutshellRepositoryImpl
import org.n27.nutshell.presentation.common.mapping.toError
import org.n27.nutshell.presentation.topics.entities.TopicsAction
import org.n27.nutshell.presentation.topics.entities.TopicsAction.NextButtonClicked
import org.n27.nutshell.presentation.topics.entities.TopicsAction.RetryButtonClicked
import org.n27.nutshell.presentation.topics.entities.TopicsEvent
import org.n27.nutshell.presentation.topics.entities.TopicsEvent.GoToNextScreen
import org.n27.nutshell.presentation.topics.entities.TopicsUiState
import org.n27.nutshell.presentation.topics.entities.TopicsUiState.Content
import org.n27.nutshell.presentation.topics.entities.TopicsUiState.Error
import org.n27.nutshell.presentation.topics.entities.TopicsUiState.Loading
import javax.inject.Inject

class TopicsViewModel @Inject constructor(
    private val repository: NutshellRepositoryImpl,
    private val tracker: TopicsTracker
) : ViewModel() {

    private val state = MutableStateFlow<TopicsUiState>(Loading)
    internal val uiState = state.asStateFlow()

    private val event = Channel<TopicsEvent>(capacity = 1, BufferOverflow.DROP_OLDEST)
    val viewEvent = event.receiveAsFlow()

    init { getTopics() }

    fun handleAction(action: TopicsAction) {
        when (action) {
            RetryButtonClicked -> onRetryButtonClicked()
            is NextButtonClicked -> onNextButtonClicked(action)
        }
    }

    private fun onRetryButtonClicked() {
        getTopics()
        tracker.trackRetryButton()
    }

    private fun onNextButtonClicked(action: NextButtonClicked) {
        event.trySend(GoToNextScreen(action.key, action.title))
        tracker.trackItem(action.key)
    }

    private fun getTopics() {
        viewModelScope.launch {
            state.emit(Loading)

            repository.getTopics()
                .onSuccess {
                    state.emit(Content(it.items.toPersistentList()))
                    tracker.trackScreenView()
                }
                .onFailure {
                    state.emit(Error(it.toError()))
                    tracker.trackError(it)
                }
        }
    }
}