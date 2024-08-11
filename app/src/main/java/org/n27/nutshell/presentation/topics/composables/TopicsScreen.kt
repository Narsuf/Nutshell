package org.n27.nutshell.presentation.topics.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import org.n27.nutshell.R
import org.n27.nutshell.presentation.common.composables.cards.Card
import org.n27.nutshell.presentation.common.composables.cards.CardContainer
import org.n27.nutshell.presentation.common.composables.Screen
import org.n27.nutshell.presentation.common.composables.Icon
import org.n27.nutshell.presentation.common.constants.Spacing
import org.n27.nutshell.presentation.common.constants.Typography
import org.n27.nutshell.presentation.topics.entities.TopicsAction
import org.n27.nutshell.presentation.topics.entities.TopicsAction.NextButtonClicked
import org.n27.nutshell.presentation.topics.entities.TopicsUiStates.Content

@Composable
fun TopicsScreen(content: Content, onAction: (action: TopicsAction) -> Unit) {

    Screen(
        title = stringResource(R.string.topics_fragment_label),
        modifier = Modifier.padding(horizontal = Spacing.default)
    ) {
        content.cardList.forEach {
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
}
