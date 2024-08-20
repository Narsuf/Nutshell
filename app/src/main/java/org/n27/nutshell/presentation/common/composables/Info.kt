package org.n27.nutshell.presentation.common.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import org.n27.nutshell.presentation.common.constants.Palette
import org.n27.nutshell.presentation.common.constants.Spacing

private val IconSize = 16.dp

@Composable
fun Info(text: String, testTag: String, onClick: () -> Unit) {

    Row(
        Modifier
            .testTag(testTag)
            .clickable { onClick() }
    ) {
        Icon(
            painter = painterResource(android.R.drawable.ic_dialog_info),
            contentDescription = null,
            modifier = Modifier.size(IconSize),
            tint = Palette.Teal600
        )
        Text(
            text = text,
            modifier = Modifier.padding(start = Spacing.tighter),
            color = Palette.Teal600
        )
    }
}
