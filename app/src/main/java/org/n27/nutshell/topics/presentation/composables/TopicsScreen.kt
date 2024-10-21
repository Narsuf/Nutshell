package org.n27.nutshell.topics.presentation.composables

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import org.n27.nutshell.R
import org.n27.nutshell.common.presentation.composables.Lottie
import org.n27.nutshell.common.presentation.composables.screen.ErrorScreen
import org.n27.nutshell.common.presentation.composables.screen.Screen
import org.n27.nutshell.common.presentation.fundamental.dimens.Spacing
import org.n27.nutshell.topics.presentation.entities.TopicsAction
import org.n27.nutshell.topics.presentation.entities.TopicsAction.RetryButtonClicked
import org.n27.nutshell.topics.presentation.entities.TopicsUiState
import org.n27.nutshell.topics.presentation.entities.TopicsUiState.Content
import org.n27.nutshell.topics.presentation.entities.TopicsUiState.Error
import org.n27.nutshell.topics.presentation.entities.TopicsUiState.Loading

internal const val TEST_TAG_TOPICS_LOADING_VIEW = "topics_loading.view"

@Composable
fun TopicsScreen(uiState: TopicsUiState, onAction: (action: TopicsAction) -> Unit) {

    Screen(
        title = stringResource(R.string.topics_fragment_label),
        modifier = Modifier.padding(top = Spacing.tight)
    ) {
        when (uiState) {
            Loading -> Loader()
            is Content -> TopicsContent(uiState, onAction)
            is Error -> ErrorScreen(
                error = uiState.error,
                onButtonClick = { onAction(RetryButtonClicked) }
            )
        }
    }
}

@Composable
private fun Loader() {
    Lottie(
        res = R.raw.loading,
        modifier = Modifier
            .testTag(TEST_TAG_TOPICS_LOADING_VIEW)
            .fillMaxSize()
    )
}
