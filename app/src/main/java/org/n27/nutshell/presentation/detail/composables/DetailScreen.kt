package org.n27.nutshell.presentation.detail.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import org.n27.nutshell.presentation.common.composables.screen.Screen
import org.n27.nutshell.presentation.detail.entities.DetailAction
import org.n27.nutshell.presentation.detail.entities.DetailUiState

@Composable
fun DetailScreen(title: String, state: DetailUiState, onAction: (action: DetailAction) -> Unit) {

    Screen(
        title = title,
        isScrollEnabled = false,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        when (state) {
            is DetailUiState.HasNavItems -> DetailNavScreen(state, onAction)
            else -> Unit
        }
    }
}

