package org.n27.nutshell.presentation.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
import org.n27.nutshell.Constants.EMPTY_NAV_ICONS_LIST
import org.n27.nutshell.data.NutshellRepositoryImpl
import org.n27.nutshell.presentation.common.mapping.toError
import org.n27.nutshell.presentation.detail.entities.DetailAction
import org.n27.nutshell.presentation.detail.entities.DetailAction.BackClicked
import org.n27.nutshell.presentation.detail.entities.DetailAction.GetNavIcons
import org.n27.nutshell.presentation.detail.entities.DetailAction.InfoClicked
import org.n27.nutshell.presentation.detail.entities.DetailAction.NavItemClicked
import org.n27.nutshell.presentation.detail.entities.DetailEvent
import org.n27.nutshell.presentation.detail.entities.DetailEvent.GoBack
import org.n27.nutshell.presentation.detail.entities.DetailEvent.OpenUrl
import org.n27.nutshell.presentation.detail.entities.DetailViewModelState
import org.n27.nutshell.presentation.detail.mapping.toUiState

class DetailViewModel @AssistedInject constructor(
    @Assisted private val key: String,
    private val repository: NutshellRepositoryImpl
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

    fun handleAction(action: DetailAction) {
        when (action) {
            GetNavIcons -> getNavIcons()
            BackClicked -> event.trySend(GoBack)
            is InfoClicked -> event.trySend(OpenUrl(action.url))
            is NavItemClicked -> getDetail(action.id)
        }
    }

    private fun getNavIcons() {
        viewModelScope.launch {
            repository.getDetailNavItems(key)
                .onFailure(::handleFailure)
                .onSuccess { navItems ->
                    navItems.items.takeIf { it.isNotEmpty() }
                        ?.let { items ->
                            viewModelState.update {
                                it.copy(
                                    navItems = items,
                                    isLoading = false,
                                    error = null
                                )
                            }

                            getDetail(items[0].id)
                        } ?: handleFailure(Throwable(EMPTY_NAV_ICONS_LIST))
                }
        }
    }

    private fun getDetail(id: String) {
        viewModelScope.launch {

            viewModelState.update { it.copy(isLoading = true) }

            repository.getDetail(key, id)
                .onFailure(::handleFailure)
                .onSuccess { detail ->
                    viewModelState.update { it.copy(content = detail) }
                }
        }
    }

    private fun handleFailure(throwable: Throwable) {
        viewModelState.update {
            it.copy(
                isLoading = false,
                error = throwable.toError()
            )
        }
    }

    @AssistedFactory
    interface Factory {
        fun create(key: String): DetailViewModel
    }
}