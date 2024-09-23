package org.n27.nutshell.presentation.topics.composables

import androidx.annotation.VisibleForTesting
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toPersistentList
import org.n27.nutshell.domain.topics.model.Topic
import org.n27.nutshell.presentation.common.composables.theme.Theme
import org.n27.nutshell.presentation.topics.entities.TopicsUiState.Content
import org.n27.nutshell.presentation.topics.entities.TopicsUiState.Error
import org.n27.nutshell.presentation.topics.entities.TopicsUiState.Loading

@Preview
@Composable
@VisibleForTesting
internal fun TopicsContentScreenPreview() = Theme {
    TopicsScreen(
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
}

@Preview
@Composable
@VisibleForTesting
internal fun TopicsContentScrollableScreenPreview() = Theme {
    TopicsScreen(
        uiState = Content(
            topics = buildList {
                repeat(10) {
                    add(
                        Topic(
                            key = "taxes$it",
                            title = "Taxes in Europe",
                            imageUrl = "http://fake.icon.url.com"
                        )
                    )
                }
            }.toPersistentList()
        ),
        onAction = { }
    )
}

@Preview
@Composable
@VisibleForTesting
internal fun TopicsErrorScreenPreview() = Theme {
    TopicsScreen(
        uiState = Error(
            error = org.n27.nutshell.presentation.common.model.Error()
        ),
        onAction = { }
    )
}

@Preview
@Composable
@VisibleForTesting
internal fun TopicsLoadingScreenPreview() = Theme {
    TopicsScreen(uiState = Loading, onAction = { })
}

@Preview
@Composable
@VisibleForTesting
internal fun TopicsContentScreenDarkModePreview() = Theme(isDarkTheme = true) {
    TopicsScreen(
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
}

@Preview
@Composable
@VisibleForTesting
internal fun TopicsContentScrollableScreenDarkModePreview() = Theme(isDarkTheme = true) {
    TopicsScreen(
        uiState = Content(
            topics = buildList {
                repeat(10) {
                    add(
                        Topic(
                            key = "taxes$it",
                            title = "Taxes in Europe",
                            imageUrl = "http://fake.icon.url.com"
                        )
                    )
                }
            }.toPersistentList()
        ),
        onAction = { }
    )
}

@Preview
@Composable
@VisibleForTesting
internal fun TopicsErrorScreenDarkModePreview() = Theme(isDarkTheme = true) {
    TopicsScreen(
        uiState = Error(
            error = org.n27.nutshell.presentation.common.model.Error()
        ),
        onAction = { }
    )
}

@Preview
@Composable
@VisibleForTesting
internal fun TopicsLoadingScreenDarkModePreview() = Theme(isDarkTheme = true) {
    TopicsScreen(uiState = Loading, onAction = { })
}
