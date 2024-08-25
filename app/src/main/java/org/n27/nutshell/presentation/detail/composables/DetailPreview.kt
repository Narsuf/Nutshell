package org.n27.nutshell.presentation.detail.composables

import androidx.annotation.VisibleForTesting
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toPersistentList
import org.n27.nutshell.R
import org.n27.nutshell.domain.detail.model.Detail.NavItem
import org.n27.nutshell.domain.detail.model.Detail.Tab.Info
import org.n27.nutshell.presentation.common.model.Error
import org.n27.nutshell.presentation.detail.entities.DetailUiState.HasContent
import org.n27.nutshell.presentation.detail.entities.DetailUiState.HasContent.TabContent
import org.n27.nutshell.presentation.detail.entities.DetailUiState.NoContent

@Preview
@Composable
@VisibleForTesting
internal fun DetailContentScreenPreview() = DetailScreen(
    title = "Taxes in Europe",
    uiState = HasContent(
        tab = TabContent(
            persistentListOf(
                Info(
                    iconUrl = "http://fake.flag.icon.url.com",
                    text = "Spain",
                    value = "54"
                ),
                Info(
                    iconUrl = "http://fake.flag.icon.url.com",
                    text = "Germany",
                    value = "47.5"
                )
            ),
            sourceUrl = "http://fake.url.com"
        ),
        nav = persistentListOf(
            NavItem(
                id = 0,
                iconUrl = "http://fake.url.com",
                label = "Income"
            ),
            NavItem(
                id = 1,
                iconUrl = "http://fake.url.com",
                label = "VAT"
            )
        )
    ),
    onAction = { }
)

@Preview
@Composable
@VisibleForTesting
internal fun DetailContentScrollableScreenPreview() = DetailScreen(
    title = "Taxes in Europe",
    uiState = HasContent(
        tab = TabContent(
            infoList = buildList {
                repeat(10) {
                    add(
                        Info(
                            iconUrl = "http://fake.flag.icon.url.com",
                            text = "Germany$it",
                            value = "47.5"
                        )
                    )
                }
            }.toPersistentList(),
            sourceUrl = "http://fake.url.com"
        ),
        nav = persistentListOf(
            NavItem(
                id = 0,
                iconUrl = "http://fake.url.com",
                label = "Income"
            ),
            NavItem(
                id = 1,
                iconUrl = "http://fake.url.com",
                label = "VAT"
            )
        )
    ),
    onAction = { }
)

@Preview
@Composable
@VisibleForTesting
internal fun DetailContentWithoutNavScreenPreview() = DetailScreen(
    title = "Income equality in Europe",
    uiState = HasContent(
        tab = TabContent(
            persistentListOf(
                Info(
                    iconUrl = "http://fake.flag.icon.url.com",
                    text = "Germany",
                    value = "0.296"
                ),
                Info(
                    iconUrl = "http://fake.flag.icon.url.com",
                    text = "Spain",
                    value = "0.320"
                )
            ),
            sourceUrl = "http://fake.url.com"
        ),
        nav = persistentListOf(
            NavItem(
                id = 0,
                iconUrl = "http://fake.url.com",
                label = "Gini"
            ),
        )
    ),
    onAction = { }
)

@Preview
@Composable
@VisibleForTesting
internal fun DetailContentWithoutNavScrollableScreenPreview() = DetailScreen(
    title = "Taxes in Europe",
    uiState = HasContent(
        tab = TabContent(
            infoList = buildList {
                repeat(11) {
                    add(
                        Info(
                            iconUrl = "http://fake.flag.icon.url.com",
                            text = "Germany$it",
                            value = "47.5"
                        )
                    )
                }
            }.toPersistentList(),
            sourceUrl = "http://fake.url.com"
        ),
        nav = persistentListOf(
            NavItem(
                id = 0,
                iconUrl = "http://fake.url.com",
                label = "Gini"
            )
        )
    ),
    onAction = { }
)

@Preview
@Composable
@VisibleForTesting
internal fun DetailErrorScreenPreview() = DetailScreen(
    title = "Taxes in Europe",
    uiState = NoContent(
        isLoading = false,
        error = Error(
            title = R.string.no_internet_error_title,
            description = R.string.no_internet_error_description
        )
    ),
    onAction = { }
)

@Preview
@Composable
@VisibleForTesting
internal fun DetailLoadingScreenPreview() = DetailScreen(
    title = "Taxes in Europe",
    uiState = NoContent(
        isLoading = true,
        error = null
    ),
    onAction = { }
)
