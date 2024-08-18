package org.n27.nutshell.topics.tests

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.n27.nutshell.presentation.getTopicsContent
import com.n27.nutshell.presentation.getTopicsError
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain
import org.junit.runner.RunWith
import org.n27.nutshell.presentation.topics.composables.TopicsScreen
import org.n27.nutshell.presentation.topics.entities.TopicsUiState.Loading
import org.n27.nutshell.topics.robots.TopicsRobot.Companion.topics

@RunWith(AndroidJUnit4::class)
class TopicsFragmentUiTest {

    private val composeTestRule = createComposeRule()

    @get:Rule
    val baseRuleChain: RuleChain by lazy {
        RuleChain
            .emptyRuleChain()
            .around(composeTestRule)
    }

    @Test
    fun checkTopicsContentScreenElements() {
        composeTestRule.setContent {
            TopicsScreen(uiState = getTopicsContent(), onAction = { })
        }

        topics(composeTestRule) {
            isTopicsItemDisplayed(0, "Taxes in Europe")
        }
    }

    @Test
    fun checkTopicsLoadingScreenElements() {
        composeTestRule.setContent {
            TopicsScreen(uiState = Loading, onAction = { })
        }

        topics(composeTestRule) {
            isTopicsLoaderDisplayed()
        }
    }

    @Test
    fun checkTopicsErrorScreenElements() {
        composeTestRule.setContent {
            TopicsScreen(uiState = getTopicsError(), onAction = { })
        }

        topics(composeTestRule) {
            isTopicsErrorDisplayed("Oops!", "Something went wrong")
        }
    }
}