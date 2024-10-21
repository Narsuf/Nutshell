package org.n27.nutshell.common.presentation.composables.buttons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import org.n27.nutshell.common.presentation.composables.theme.Theme
import org.n27.nutshell.common.presentation.extensions.clickable
import org.n27.nutshell.common.presentation.fundamental.Typography
import org.n27.nutshell.common.presentation.fundamental.dimens.CornerRadius
import org.n27.nutshell.common.presentation.fundamental.dimens.Spacing

private val ButtonHeight = 40.dp

@Composable
fun Button(onClick: () -> Unit, text: String) {

    Surface(
        modifier = Modifier
            .height(ButtonHeight)
            .semantics { role = Role.Button }
            .clip(RoundedCornerShape(CornerRadius.smooth))
            .clickable(onClick = onClick),
        color = Color.Transparent,
        contentColor = Theme.colors.typography.teal
    ) {
        Row(
            Modifier
                .defaultMinSize(
                    minWidth = ButtonDefaults.MinWidth,
                    minHeight = ButtonDefaults.MinHeight
                )
                .padding(PaddingValues(horizontal = Spacing.loose)),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            content = {
                Text(
                    text = text,
                    style = Typography.Bold
                )
            }
        )
    }
}
