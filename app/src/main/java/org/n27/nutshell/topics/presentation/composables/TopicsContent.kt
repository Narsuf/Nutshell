package org.n27.nutshell.topics.presentation.composables

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.testTag
import org.n27.nutshell.common.presentation.composables.Icon
import org.n27.nutshell.common.presentation.composables.cards.Card
import org.n27.nutshell.common.presentation.composables.cards.CardContainer
import org.n27.nutshell.common.presentation.composables.theme.themeDefaultTypography
import org.n27.nutshell.common.presentation.fundamental.Typography
import org.n27.nutshell.common.presentation.fundamental.dimens.Spacing
import org.n27.nutshell.topics.presentation.entities.TopicsAction
import org.n27.nutshell.topics.presentation.entities.TopicsAction.NextButtonClicked
import org.n27.nutshell.topics.presentation.entities.TopicsUiState.Content

internal const val TEST_TAG_TOPICS_ITEM = "topics.item"

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
                            modifier = Modifier.testTag("${TEST_TAG_TOPICS_ITEM}_$index"),
                            color = themeDefaultTypography(),
                            style = Typography.Bold
                        )
                    },
                    endContent = {
                        Icon(
                            url = topic.imageUrl,
                            colorFilter = ColorFilter.tint(themeDefaultTypography())
                        )
                    },
                    onClick = { onAction(NextButtonClicked(topic.key, topic.title)) }
                )
            }
        }
    }
}
