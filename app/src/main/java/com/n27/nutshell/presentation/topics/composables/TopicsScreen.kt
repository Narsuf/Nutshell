package com.n27.nutshell.presentation.topics.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.n27.nutshell.R
import com.n27.nutshell.presentation.common.composables.cards.Card
import com.n27.nutshell.presentation.common.composables.cards.CardContainer
import com.n27.nutshell.presentation.common.composables.Screen
import com.n27.nutshell.presentation.common.constants.Spacing
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
                onClick = { onAction(NextButtonClicked) },
                text = "Taxes in the EU",
                endIconUrl = "http://cdn-icons-png.flaticon.com/128/6049/6049398.png"
            )
        }
    }
}
