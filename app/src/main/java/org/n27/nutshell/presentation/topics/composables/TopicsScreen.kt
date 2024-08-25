package org.n27.nutshell.presentation.topics.composables

import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.collections.immutable.persistentListOf
import org.n27.nutshell.R
import org.n27.nutshell.domain.topics.model.Topic
import org.n27.nutshell.presentation.common.composables.Lottie
import org.n27.nutshell.presentation.common.composables.screen.ErrorScreen
import org.n27.nutshell.presentation.common.composables.screen.Screen
import org.n27.nutshell.presentation.common.constants.Spacing
import org.n27.nutshell.presentation.topics.entities.TopicsAction
import org.n27.nutshell.presentation.topics.entities.TopicsAction.RetryButtonClicked
import org.n27.nutshell.presentation.topics.entities.TopicsUiState
import org.n27.nutshell.presentation.topics.entities.TopicsUiState.Content
import org.n27.nutshell.presentation.topics.entities.TopicsUiState.Error
import org.n27.nutshell.presentation.topics.entities.TopicsUiState.Loading
import org.n27.nutshell.presentation.common.model.Error as MyError

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

@Preview
@Composable
@VisibleForTesting
internal fun TopicsContentScreenPreview() = TopicsScreen(
    uiState = Content(
        topics = persistentListOf(
            Topic(
                key = "taxes",
                title = "Taxes in Europe",
                imageUrl = "http://fake.icon.url.com"
            ),
            Topic(
                key = "gini",
                title = "Income equality in Europe",
                imageUrl = "http://fake.icon.url.com"
            )
        )
    ),
    onAction = { }
)

@Preview
@Composable
@VisibleForTesting
internal fun TopicsErrorScreenPreview() = TopicsScreen(
    uiState = Error(
        error = MyError()
    ),
    onAction = { }
)

@Preview
@Composable
@VisibleForTesting
internal fun TopicsLoadingScreenPreview() = TopicsScreen(uiState = Loading, onAction = { })
