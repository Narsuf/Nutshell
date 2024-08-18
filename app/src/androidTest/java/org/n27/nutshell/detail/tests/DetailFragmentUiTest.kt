package org.n27.nutshell.detail.tests

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.n27.nutshell.presentation.getError
import com.n27.nutshell.presentation.getHasContent
import com.n27.nutshell.presentation.getNoContent
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain
import org.junit.runner.RunWith
import org.n27.nutshell.detail.robots.DetailRobot.Companion.detail
import org.n27.nutshell.presentation.detail.composables.DetailScreen

@RunWith(AndroidJUnit4::class)
class DetailFragmentUiTest {

    private val composeTestRule = createComposeRule()

    @get:Rule
    val baseRuleChain: RuleChain by lazy {
        RuleChain
            .emptyRuleChain()
            .around(composeTestRule)
    }

    @Test
    fun checkDetailContentScreenElements() {
        composeTestRule.setContent {
            DetailScreen(title = "taxes", uiState = getHasContent(), onAction = { })
        }

        detail(composeTestRule) {
            isDetailItemDisplayed(0, "Germany", "19")
        }
    }

    @Test
    fun checkDetailLoadingScreenElements() {
        composeTestRule.setContent {
            DetailScreen(title = "taxes", uiState = getNoContent(), onAction = { })
        }

        detail(composeTestRule) {
            isDetailLoaderDisplayed()
        }
    }

    @Test
    fun checkDetailErrorScreenElements() {
        composeTestRule.setContent {
            DetailScreen(
                title = "taxes",
                uiState = getNoContent(
                    isLoading = false,
                    error = getError()
                ),
                onAction = { }
            )
        }

        detail(composeTestRule) {
            isDetailErrorDisplayed()
        }
    }
}