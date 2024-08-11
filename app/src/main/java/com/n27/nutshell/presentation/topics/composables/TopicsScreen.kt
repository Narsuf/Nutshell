package com.n27.nutshell.presentation.topics.composables

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.n27.nutshell.R
import com.n27.nutshell.presentation.common.composables.Screen
import com.n27.nutshell.presentation.topics.entities.TopicsAction
import com.n27.nutshell.presentation.topics.entities.TopicsAction.NextButtonClicked

@Composable
fun TopicsScreen(onAction: (action: TopicsAction) -> Unit) {

    Screen(title = stringResource(R.string.topics_fragment_label)) {
        Button(
            onClick = { onAction(NextButtonClicked) }
        ) {
            Text(stringResource(R.string.next))
        }

        Text(stringResource(R.string.lorem_ipsum))
    }
}
