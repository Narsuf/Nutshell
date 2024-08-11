package org.n27.nutshell.presentation.topics.composables

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import org.n27.nutshell.presentation.common.composables.Icon
import org.n27.nutshell.presentation.common.composables.cards.Card
import org.n27.nutshell.presentation.common.composables.cards.CardContainer
import org.n27.nutshell.presentation.common.constants.Typography
import org.n27.nutshell.presentation.topics.entities.TopicsAction
import org.n27.nutshell.presentation.topics.entities.TopicsAction.NextButtonClicked
import org.n27.nutshell.presentation.topics.entities.TopicsUiState.Content

@Composable
fun TopicsContent(content: Content, onAction: (action: TopicsAction) -> Unit) {

    content.topics.forEach {
        CardContainer {
            Card(
                mainContent = {
                    Text(
                        text = it.title,
                        style = Typography.Bold
                    )
                },
                endContent = { Icon(it.imageUrl) },
                onClick = { onAction(NextButtonClicked(it.key)) },
            )
        }
    }
}