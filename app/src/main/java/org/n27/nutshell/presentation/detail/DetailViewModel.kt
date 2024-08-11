package org.n27.nutshell.presentation.detail

import androidx.lifecycle.ViewModel
import org.n27.nutshell.presentation.detail.entities.DetailAction
import org.n27.nutshell.presentation.detail.entities.DetailEvent
import org.n27.nutshell.presentation.detail.entities.DetailEvent.OpenUrl
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject

class DetailViewModel @Inject constructor() : ViewModel() {

    private val event = Channel<DetailEvent>(capacity = 1, BufferOverflow.DROP_OLDEST)
    val viewEvent = event.receiveAsFlow()

    fun handleAction(action: DetailAction) = when (action) {
        is DetailAction.InfoClicked -> event.trySend(OpenUrl(action.url))
    }
}