package org.n27.nutshell.presentation.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.ktx.Firebase
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.n27.nutshell.Constants.EMPTY_LIST
import org.n27.nutshell.data.NutshellRepositoryImpl
import org.n27.nutshell.domain.detail.model.Detail
import org.n27.nutshell.presentation.common.mapping.toError
import org.n27.nutshell.presentation.detail.entities.DetailAction
import org.n27.nutshell.presentation.detail.entities.DetailAction.BackClicked
import org.n27.nutshell.presentation.detail.entities.DetailAction.GetDetail
import org.n27.nutshell.presentation.detail.entities.DetailAction.InfoClicked
import org.n27.nutshell.presentation.detail.entities.DetailAction.NavItemClicked
import org.n27.nutshell.presentation.detail.entities.DetailAction.RetryClicked
import org.n27.nutshell.presentation.detail.entities.DetailEvent
import org.n27.nutshell.presentation.detail.entities.DetailEvent.GoBack
import org.n27.nutshell.presentation.detail.entities.DetailEvent.OpenUrl
import org.n27.nutshell.presentation.detail.entities.DetailViewModelState
import org.n27.nutshell.presentation.detail.mapping.toUiState

class DetailViewModel @AssistedInject constructor(
    @Assisted private val key: String,
    private val repository: NutshellRepositoryImpl,
    private val tracker: DetailTracker
) : ViewModel() {

    private val viewModelState = MutableStateFlow(DetailViewModelState())
    val uiState = viewModelState
        .map(DetailViewModelState::toUiState)
        .stateIn(
            viewModelScope,
            SharingStarted.Eagerly,
            viewModelState.value.toUiState()
        )

    private val event = Channel<DetailEvent>(capacity = 1, BufferOverflow.DROP_OLDEST)
    val viewEvent = event.receiveAsFlow()

    private lateinit var detail: Detail

    fun handleAction(action: DetailAction) {
        when (action) {
            GetDetail -> getDetail()
            BackClicked -> onBackClicked()
            RetryClicked -> onRetryClicked()
            is InfoClicked -> onInfoClicked(action)
            is NavItemClicked -> onNavItemClicked(action)
        }
    }

    private fun onBackClicked() {
        event.trySend(GoBack)
        tracker.trackBackClick(key)
    }

    private fun onRetryClicked() {
        getDetail()
        tracker.trackRetryButton(key)
    }

    private fun onInfoClicked(action: InfoClicked) {
        event.trySend(OpenUrl(action.url))
        tracker.trackSourceButton(key, action.navScreen)
    }

    private fun onNavItemClicked(action: NavItemClicked) {
        getTab(action.id)
        tracker.trackNavClick(key, action.label)
    }

    private fun getTab(id: Int) {
        viewModelState.update {
            it.copy(tab = detail.tabs[id])
        }
    }

    private fun getDetail() {
        viewModelScope.launch {

            viewModelState.update { it.copy(isLoading = true) }

            repository.getDetail(key)
                .onSuccess(::handleSuccess)
                .onFailure(::handleFailure)
        }
    }

    private fun handleSuccess(it: Detail) {
        if (it.tabs.isEmpty()) {
            handleFailure(Throwable(EMPTY_LIST))
        } else {
            detail = it
            viewModelState.update { state ->
                state.copy(
                    tab = it.tabs[0],
                    nav = it.nav,
                    isLoading = false,
                    error = null
                )
            }

            tracker.trackScreenView(key)
        }
    }

    private fun handleFailure(throwable: Throwable) {
        viewModelState.update {
            it.copy(isLoading = false, error = throwable.toError())
        }

        tracker.trackError(throwable)
    }

    @AssistedFactory
    interface Factory {
        fun create(key: String): DetailViewModel
    }
}