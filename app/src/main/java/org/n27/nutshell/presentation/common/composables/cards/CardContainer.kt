package org.n27.nutshell.presentation.common.composables.cards

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.n27.nutshell.presentation.common.composables.theme.Theme
import org.n27.nutshell.presentation.common.composables.theme.themeDefaultBackground
import org.n27.nutshell.presentation.common.composables.theme.themeDefaultStroke
import org.n27.nutshell.presentation.common.fundamental.dimens.Spacing

@Composable
fun CardContainer(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit,
) {
    val roundedCornerShape = RoundedCornerShape(Theme.cornerRadius.smooth)

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape = roundedCornerShape)
            .background(Color.Transparent, roundedCornerShape)
            .padding(bottom = Spacing.default)
            .border(
                BorderStroke(1.dp, themeDefaultStroke()),
                roundedCornerShape
            ),
        content = content
    )
}
