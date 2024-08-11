package com.n27.nutshell.presentation.topics.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.n27.nutshell.R
import com.n27.nutshell.presentation.common.composables.cards.Card
import com.n27.nutshell.presentation.common.composables.cards.CardContainer
import com.n27.nutshell.presentation.common.composables.Screen
import com.n27.nutshell.presentation.common.composables.Icon
import com.n27.nutshell.presentation.common.constants.Spacing
import com.n27.nutshell.presentation.common.constants.Typography
import com.n27.nutshell.presentation.topics.entities.TopicsAction
import com.n27.nutshell.presentation.topics.entities.TopicsAction.NextButtonClicked
import com.n27.nutshell.presentation.topics.entities.TopicsUiStates.Content

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
