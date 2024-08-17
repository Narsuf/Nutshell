package org.n27.nutshell.topics.robots

import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.onNodeWithTag
import org.n27.nutshell.presentation.topics.composables.TEST_TAG_TOPICS_ITEM

class TopicsRobot(composeTestRule: ComposeTestRule) : ComposeTestRule by composeTestRule {

    fun isTopicsItemDisplayed(index: Int, name: String) {
        onNodeWithTag("${TEST_TAG_TOPICS_ITEM}_$index", useUnmergedTree = true)
            .assertIsDisplayed()
            .assert(hasText(name))
    }

    companion object {
        fun topics(
            composeTestRule: ComposeTestRule,
            builder: TopicsRobot.() -> Unit
        ): TopicsRobot = TopicsRobot(composeTestRule).apply(builder)
    }
}