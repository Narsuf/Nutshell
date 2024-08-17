package org.n27.nutshell.topics.tests

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.n27.nutshell.presentation.getTopicsContent
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain
import org.junit.runner.RunWith
import org.n27.nutshell.presentation.topics.composables.TopicsScreen
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
    fun checkEducationScreenElements() {
        composeTestRule.setContent {
            TopicsScreen(uiState = getTopicsContent(), onAction = { })
        }

        topics(composeTestRule) {
            isTopicsItemDisplayed(0, "Taxes in Europe")
        }
    }
}