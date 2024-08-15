package org.n27.nutshell.presentation.topics.composables

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.n27.nutshell.presentation.common.composables.Icon
import org.n27.nutshell.presentation.common.composables.cards.Card
import org.n27.nutshell.presentation.common.composables.cards.CardContainer
import org.n27.nutshell.presentation.common.constants.Spacing
import org.n27.nutshell.presentation.common.constants.Typography
import org.n27.nutshell.presentation.topics.entities.TopicsAction
import org.n27.nutshell.presentation.topics.entities.TopicsAction.NextButtonClicked
import org.n27.nutshell.presentation.topics.entities.TopicsUiState.Content

@Composable
fun TopicsContent(content: Content, onAction: (action: TopicsAction) -> Unit) {

    LazyColumn(
        Modifier
            .fillMaxSize()
            .padding(horizontal = Spacing.default)
    ) {
        itemsIndexed(content.topics, key = { _, topic -> topic.key }) { index, topic ->
            CardContainer {
                Card(
                    mainContent = {
                        Text(
                            text = topic.title,
                            style = Typography.Bold
                        )
                    },
                    endContent = { Icon(topic.imageUrl) },
                    onClick = { onAction(NextButtonClicked(index, topic.key, topic.title)) },
                )
            }
        }
    }
}