package org.n27.nutshell.presentation.common.composables

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.n27.nutshell.presentation.common.fundamental.color.Palette
import org.n27.nutshell.presentation.common.fundamental.dimens.Spacing

private val ButtonHeight = 40.dp

@Composable
fun Button(onClick: () -> Unit, text: String) {

    androidx.compose.material3.Button(
        onClick = onClick,
        modifier = Modifier.height(ButtonHeight),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors().copy(
            containerColor = Color.Transparent,
            contentColor = Palette.Teal500,
        ),
        elevation = null,
        contentPadding = PaddingValues(horizontal = Spacing.loose)
    ) {
        Text(text)
    }
}
