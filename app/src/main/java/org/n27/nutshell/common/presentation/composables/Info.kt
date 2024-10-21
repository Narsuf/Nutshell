package org.n27.nutshell.common.presentation.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import org.n27.nutshell.common.presentation.composables.theme.Theme
import org.n27.nutshell.common.presentation.extensions.clickable
import org.n27.nutshell.common.presentation.fundamental.dimens.CornerRadius
import org.n27.nutshell.common.presentation.fundamental.dimens.Spacing

private val IconSize = 16.dp

@Composable
fun Info(text: String, testTag: String, onClick: () -> Unit) {

    Row(
        modifier = Modifier
            .testTag(testTag)
            .clip(RoundedCornerShape(CornerRadius.soft))
            .clickable(onClick),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(Modifier.padding(vertical = Spacing.tight))
        Spacer(Modifier.padding(start = Spacing.tightest))

        Icon(
            painter = painterResource(android.R.drawable.ic_dialog_info),
            contentDescription = null,
            modifier = Modifier.size(IconSize),
            tint = Theme.colors.typography.teal
        )
        Text(
            text = text,
            modifier = Modifier.padding(start = Spacing.tighter),
            color = Theme.colors.typography.teal
        )

        Spacer(Modifier.padding(end = Spacing.tightest))
    }
}
