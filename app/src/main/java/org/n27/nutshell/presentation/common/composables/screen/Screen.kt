package org.n27.nutshell.presentation.common.composables.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.n27.nutshell.presentation.common.composables.Toolbar
import org.n27.nutshell.presentation.common.composables.theme.themeDefaultBackground

@Composable
fun Screen(
    title: String,
    modifier: Modifier = Modifier,
    onBackClick: (() -> Unit)? = null,
    horizontalAlignment: Alignment.Horizontal = Alignment.CenterHorizontally,
    content: @Composable ColumnScope.() -> Unit
) {

    Scaffold(
        topBar = { Toolbar(title, onBackClick) }
    ) { paddingValues ->
        Column(
            modifier = modifier
                .background(themeDefaultBackground())
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = horizontalAlignment,
            content = content
        )
    }
}
