package org.n27.nutshell.detail.presentation.composables

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import org.n27.nutshell.R
import org.n27.nutshell.common.presentation.composables.Lottie
import org.n27.nutshell.common.presentation.composables.screen.ErrorScreen
import org.n27.nutshell.common.presentation.composables.screen.Screen
import org.n27.nutshell.detail.presentation.entities.DetailAction
import org.n27.nutshell.detail.presentation.entities.DetailAction.BackClicked
import org.n27.nutshell.detail.presentation.entities.DetailAction.RetryClicked
import org.n27.nutshell.detail.presentation.entities.DetailUiState
import org.n27.nutshell.detail.presentation.entities.DetailUiState.HasContent
import org.n27.nutshell.detail.presentation.entities.DetailUiState.NoContent

internal const val TEST_TAG_DETAIL_LOADING_VIEW = "detail_loading.view"

@Composable
fun DetailScreen(title: String, uiState: DetailUiState, onAction: (action: DetailAction) -> Unit) {

    Screen(title = title, onBackClick = { onAction(BackClicked) }) {
        when (uiState) {
            is HasContent -> DetailNavScreen(uiState, onAction)
            is NoContent -> if (uiState.isLoading)
                Loader()
            else
                uiState.error?.let {
                    ErrorScreen(
                        error = it,
                        onButtonClick = { onAction(RetryClicked) }
                    )
                }
        }
    }
}

@Composable
private fun Loader() {
    Lottie(
        res = R.raw.loading,
        modifier = Modifier
            .testTag(TEST_TAG_DETAIL_LOADING_VIEW)
            .fillMaxSize()
    )
}
