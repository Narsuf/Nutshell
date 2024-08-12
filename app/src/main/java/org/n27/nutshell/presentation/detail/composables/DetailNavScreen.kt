package org.n27.nutshell.presentation.detail.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.BottomNavigation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import org.n27.nutshell.R
import org.n27.nutshell.domain.detail.model.DetailNavItem
import org.n27.nutshell.presentation.common.composables.Icon
import org.n27.nutshell.presentation.common.composables.Info
import org.n27.nutshell.presentation.common.composables.cards.Card
import org.n27.nutshell.presentation.common.composables.cards.CardContainer
import org.n27.nutshell.presentation.common.composables.nav.NavItem
import org.n27.nutshell.presentation.common.constants.Spacing
import org.n27.nutshell.presentation.detail.entities.DetailAction
import org.n27.nutshell.presentation.detail.entities.DetailAction.InfoClicked
import org.n27.nutshell.presentation.detail.entities.DetailAction.NavItemClicked
import org.n27.nutshell.presentation.detail.entities.DetailUiState.HasNavItems

@Composable
fun ColumnScope.DetailNavScreen(state: HasNavItems, onAction: (action: DetailAction) -> Unit) {

    val navController = rememberNavController()
    val navItems = state.navItems

    Column(
        Modifier
            .weight(1f)
            .padding(horizontal = Spacing.default)
    ) {
        NavHost(
            navController = navController,
            startDestination = navItems[0].label
        ) {
            navItems.forEach { item ->
                composable(item.label) {
                    state.content?.let {
                        CardContainer {
                            LazyColumn {
                                items(it.info, key = { it.text }) { item ->
                                    Card(
                                        mainContent = { Text(item.text) },
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
        }

        state.content?.let {
            Info(
                text = stringResource(R.string.source),
                onClick = { onAction(InfoClicked(it.sourceUrl)) }
            )
        }
    }

    BottomNav(navController, navItems, onAction)
}

@Composable
private fun BottomNav(
    navController: NavController,
    navItems: List<DetailNavItem>,
    onAction: (action: DetailAction) -> Unit
) {

    BottomNavigation(backgroundColor = Color.White) {
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
                                navController.currentDestination?.id
                                    ?: navController.graph.startDestinationId
                            ) { inclusive = true }

                            launchSingleTop = true
                            restoreState = false
                        }

                        onAction(NavItemClicked(it.id))
                    }
                },
                imageUrl = it.iconUrl,
                label = it.label
            )
        }
    }
}