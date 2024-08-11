package com.n27.nutshell.presentation.detail.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material.BottomNavigation
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.n27.nutshell.R
import com.n27.nutshell.presentation.common.composables.NavItem
import com.n27.nutshell.presentation.common.composables.Screen
import com.n27.nutshell.presentation.common.composables.Text

@Composable
fun DetailScreen(onClick: () -> Unit) {

    Screen(
        title = stringResource(R.string.detail_fragment_label),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "Hola")
        BottomNavigation(backgroundColor = MaterialTheme.colorScheme.background) {
            listOf(
                NavItem(
                    isSelected = false,
                    onClick = onClick,
                    imageUrl = "http://cdn-icons-png.flaticon.com/128/6049/6049398.png",
                    label = "Topics"
                ),
                NavItem(
                    isSelected = true,
                    onClick = {},
                    imageUrl = "http://cdn-icons-png.flaticon.com/128/6049/6049398.png",
                    label = "Detail"
                )
            )
        }
    }
}