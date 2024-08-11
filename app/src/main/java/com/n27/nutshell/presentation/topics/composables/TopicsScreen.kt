package com.n27.nutshell.presentation.topics.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.n27.nutshell.R
import com.n27.nutshell.presentation.common.composables.cards.Card
import com.n27.nutshell.presentation.common.composables.cards.CardContainer
import com.n27.nutshell.presentation.common.composables.Screen
import com.n27.nutshell.presentation.common.composables.icons.Icon
import com.n27.nutshell.presentation.common.composables.text.Text
import com.n27.nutshell.presentation.common.constants.Spacing
import com.n27.nutshell.presentation.common.constants.Typography
import com.n27.nutshell.presentation.topics.entities.TopicsAction
import com.n27.nutshell.presentation.topics.entities.TopicsAction.NextButtonClicked

@Composable
fun TopicsScreen(onAction: (action: TopicsAction) -> Unit) {

    Screen(
        title = stringResource(R.string.topics_fragment_label),
        modifier = Modifier.padding(horizontal = Spacing.default)
    ) {
        CardContainer {
            Card(
                mainContent = {
                    Text(
                        text = "Taxes in the EU",
                        style = Typography.Bold
                    )
                },
                endContent = {
                    Icon("http://cdn-icons-png.flaticon.com/128/6049/6049398.png")
                },
                onClick = { onAction(NextButtonClicked) },
            )
        }
        CardContainer {
            Card(
                mainContent = {
                    Text(
                        text = "Taxes in the EU",
                        style = Typography.Bold
                    )
                },
                endContent = {
                    Icon("http://cdn-icons-png.flaticon.com/128/6049/6049398.png")
                },
                onClick = { onAction(NextButtonClicked) },
            )
        }
        CardContainer {
            Card(
                mainContent = {
                    Text(
                        text = "Taxes in the EU",
                        style = Typography.Bold
                    )
                },
                endContent = {
                    Icon("http://cdn-icons-png.flaticon.com/128/6049/6049398.png")
                },
                onClick = { onAction(NextButtonClicked) },
            )
        }
        CardContainer {
            Card(
                mainContent = {
                    Text(
                        text = "Taxes in the EU",
                        style = Typography.Bold
                    )
                },
                endContent = {
                    Icon("http://cdn-icons-png.flaticon.com/128/6049/6049398.png")
                },
                onClick = { onAction(NextButtonClicked) },
            )
        }
        CardContainer {
            Card(
                mainContent = {
                    Text(
                        text = "Taxes in the EU",
                        style = Typography.Bold
                    )
                },
                endContent = {
                    Icon("http://cdn-icons-png.flaticon.com/128/6049/6049398.png")
                },
                onClick = { onAction(NextButtonClicked) },
            )
        }
        CardContainer {
            Card(
                mainContent = {
                    Text(
                        text = "Taxes in the EU",
                        style = Typography.Bold
                    )
                },
                endContent = {
                    Icon("http://cdn-icons-png.flaticon.com/128/6049/6049398.png")
                },
                onClick = { onAction(NextButtonClicked) },
            )
        }
        CardContainer {
            Card(
                mainContent = {
                    Text(
                        text = "Taxes in the EU",
                        style = Typography.Bold
                    )
                },
                endContent = {
                    Icon("http://cdn-icons-png.flaticon.com/128/6049/6049398.png")
                },
                onClick = { onAction(NextButtonClicked) },
            )
        }
        CardContainer {
            Card(
                mainContent = {
                    Text(
                        text = "Taxes in the EU",
                        style = Typography.Bold
                    )
                },
                endContent = {
                    Icon("http://cdn-icons-png.flaticon.com/128/6049/6049398.png")
                },
                onClick = { onAction(NextButtonClicked) },
            )
        }
        CardContainer {
            Card(
                mainContent = {
                    Text(
                        text = "Taxes in the EU",
                        style = Typography.Bold
                    )
                },
                endContent = {
                    Icon("http://cdn-icons-png.flaticon.com/128/6049/6049398.png")
                },
                onClick = { onAction(NextButtonClicked) },
            )
        }
    }
}
