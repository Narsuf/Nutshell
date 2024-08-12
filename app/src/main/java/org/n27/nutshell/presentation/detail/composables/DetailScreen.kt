package org.n27.nutshell.presentation.detail.composables

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.n27.nutshell.R
import org.n27.nutshell.presentation.common.composables.Lottie
import org.n27.nutshell.presentation.common.composables.screen.ErrorScreen
import org.n27.nutshell.presentation.common.composables.screen.Screen
import org.n27.nutshell.presentation.detail.entities.DetailAction
import org.n27.nutshell.presentation.detail.entities.DetailAction.GetNavIcons
import org.n27.nutshell.presentation.detail.entities.DetailUiState
import org.n27.nutshell.presentation.detail.entities.DetailUiState.HasNavItems
import org.n27.nutshell.presentation.detail.entities.DetailUiState.NoNavItems

@Composable
fun DetailScreen(title: String, uiState: DetailUiState, onAction: (action: DetailAction) -> Unit) {

    Screen(title = title) {
        when (uiState) {
            is HasNavItems -> DetailNavScreen(uiState, onAction)
            is NoNavItems -> if (uiState.isLoading)
                Lottie(R.raw.loading, Modifier.fillMaxSize())
            else
                uiState.error?.let {
                    ErrorScreen(
                        error = it,
                        onButtonClick = { onAction(GetNavIcons) }
                    )
                }
        }
    }
}
