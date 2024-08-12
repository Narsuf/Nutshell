package org.n27.nutshell.presentation.common.composables.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.n27.nutshell.presentation.common.composables.Toolbar
import org.n27.nutshell.presentation.common.constants.Spacing

@Composable
fun Screen(
    title: String,
    isScrollEnabled: Boolean = true,
    verticalArrangement: Arrangement.Vertical = Arrangement.Top,
    content: @Composable ColumnScope.() -> Unit
) {

    val scroll = if (isScrollEnabled)
        Modifier.verticalScroll(rememberScrollState())
    else
        Modifier

    Scaffold(
        topBar = { Toolbar(title) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize()
                .padding(paddingValues)
                .padding(top = Spacing.default)
                .then(scroll),
            verticalArrangement = verticalArrangement,
            content = content
        )
    }
}