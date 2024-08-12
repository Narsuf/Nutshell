package org.n27.nutshell.presentation.common.composables

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import org.n27.nutshell.presentation.common.constants.Spacing
import org.n27.nutshell.presentation.common.constants.Typography

@Composable
fun Toolbar(text: String) {

    Surface {
        Row(
            Modifier
                .background(Color.White)
                .fillMaxWidth()
                .padding(
                    vertical = Spacing.tight,
                    horizontal = Spacing.default,
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(Modifier.weight(1f)) {
                AnimatedContent(
                    targetState = text,
                    label = "Toolbar title changed"
                ) { value ->
                    Text(
                        text = value,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1,
                        style = Typography.Title
                    )
                }
            }
        }
    }
}