package com.n27.nutshell.presentation.detail.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.BottomNavigation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.n27.nutshell.R
import com.n27.nutshell.presentation.common.composables.Info
import com.n27.nutshell.presentation.common.composables.NavItem
import com.n27.nutshell.presentation.common.composables.Screen
import com.n27.nutshell.presentation.common.composables.cards.Card
import com.n27.nutshell.presentation.common.composables.cards.CardContainer
import com.n27.nutshell.presentation.common.composables.icons.Icon
import com.n27.nutshell.presentation.common.constants.Spacing
import com.n27.nutshell.presentation.detail.entities.DetailUiState.Content
import com.n27.nutshell.presentation.detail.entities.DetailUiState.Content.NavItem

@Composable
fun DetailScreen(content: Content, onClick: () -> Unit) {

    val navController = rememberNavController()
    val navItems = content.navItems

    Screen(
        title = content.title,
        isScrollEnabled = false,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        NavHost(
            navController = navController,
            startDestination = navItems[0].label,
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = Spacing.default)
        ) {
            navItems.forEach { item ->
                composable(item.label) {
                    CardContainer {
                        LazyColumn {
                            items(content.infoList, key = { it.text }) { item ->
                                Card(
                                    mainContent = { Text(item.text) } ,
                                    endContent = { Text(item.value) },
                                    startContent = { Icon(item.iconUrl) },
                                    includeDivider = true
                                )
                            }
                        }
                    }
                }
            }
        }

        Row(
            Modifier.padding(
                start = Spacing.default,
                bottom = Spacing.default
            )
        ) {
            Info(text = stringResource(R.string.source), onClick = onClick)
        }

        BottomNav(navController, navItems)
    }
}

@Composable
private fun BottomNav(navController: NavController, navItems: List<NavItem>) {

    BottomNavigation(backgroundColor = MaterialTheme.colorScheme.background) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        navItems.forEach {
            val isSelected = currentRoute == it.label

            NavItem(
                isSelected = isSelected,
                onClick = {
                    if (!isSelected) {
                        navController.navigate(it.label) {
                            popUpTo(
                                navController.currentDestination?.id ?:
                                navController.graph.startDestinationId
                            ) { inclusive = true }

                            launchSingleTop = true
                            restoreState = false
                        }
                    }
                },
                imageUrl = it.iconUrl,
                label = it.label
            )
        }
    }
}
