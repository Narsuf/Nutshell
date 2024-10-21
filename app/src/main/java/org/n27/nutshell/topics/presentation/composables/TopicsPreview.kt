package org.n27.nutshell.topics.presentation.composables

import androidx.annotation.VisibleForTesting
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toPersistentList
import org.n27.nutshell.common.presentation.composables.theme.Theme
import org.n27.nutshell.topics.domain.model.Topic
import org.n27.nutshell.topics.presentation.entities.TopicsUiState.Content
import org.n27.nutshell.topics.presentation.entities.TopicsUiState.Error
import org.n27.nutshell.topics.presentation.entities.TopicsUiState.Loading
import org.n27.nutshell.common.presentation.model.Error as MyError

@Preview
@Composable
@VisibleForTesting
internal fun TopicsLoadingScreenPreview() = Theme {
    TopicsScreen(uiState = Loading, onAction = { })
}

@Preview
@Composable
@VisibleForTesting
internal fun TopicsLoadingScreenDarkModePreview() = Theme(isDarkTheme = true) {
    TopicsScreen(uiState = Loading, onAction = { })
}

@Preview
@Composable
@VisibleForTesting
internal fun TopicsErrorScreenPreview() = Theme {
    TopicsScreen(
        uiState = Error(
            error = MyError()
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
            error = MyError()
        ),
        onAction = { }
    )
}

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
