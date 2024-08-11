package org.n27.nutshell.presentation.topics.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import org.n27.nutshell.R
import org.n27.nutshell.presentation.common.composables.Screen
import org.n27.nutshell.presentation.common.constants.Spacing
import org.n27.nutshell.presentation.topics.entities.TopicsAction
import org.n27.nutshell.presentation.topics.entities.TopicsUiState
import org.n27.nutshell.presentation.topics.entities.TopicsUiState.Content

@Composable
fun TopicsScreen(uiState: TopicsUiState, onAction: (action: TopicsAction) -> Unit) {

    Screen(
        title = stringResource(R.string.topics_fragment_label),
        modifier = Modifier.padding(horizontal = Spacing.default)
    ) {
        when (uiState) {
            is Content -> TopicsContent(uiState, onAction)
            else -> Unit
        }
    }
}
