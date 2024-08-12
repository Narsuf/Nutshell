package org.n27.nutshell.presentation.detail.composables

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.n27.nutshell.R
import org.n27.nutshell.presentation.common.composables.Lottie
import org.n27.nutshell.presentation.common.composables.screen.ErrorScreen
import org.n27.nutshell.presentation.common.composables.screen.Screen
import org.n27.nutshell.presentation.detail.entities.DetailAction
import org.n27.nutshell.presentation.detail.entities.DetailAction.BackClicked
import org.n27.nutshell.presentation.detail.entities.DetailAction.GetDetail
import org.n27.nutshell.presentation.detail.entities.DetailUiState
import org.n27.nutshell.presentation.detail.entities.DetailUiState.HasContent
import org.n27.nutshell.presentation.detail.entities.DetailUiState.NoContent

@Composable
fun DetailScreen(title: String, uiState: DetailUiState, onAction: (action: DetailAction) -> Unit) {

    Screen(title = title, onBackClick = { onAction(BackClicked) }) {
        when (uiState) {
            is HasContent -> DetailNavScreen(uiState, onAction)
            is NoContent -> if (uiState.isLoading)
                Lottie(R.raw.loading, Modifier.fillMaxSize())
            else
                uiState.error?.let {
                    ErrorScreen(
                        error = it,
                        onButtonClick = { onAction(GetDetail) }
                    )
                }
        }
    }
}
