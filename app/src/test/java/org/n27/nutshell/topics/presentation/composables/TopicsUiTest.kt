package org.n27.nutshell.topics.presentation.composables

import org.junit.Test
import org.n27.nutshell.screenshot.PaparazziScreenTest
import org.n27.nutshell.screenshot.TestConfig

class TopicsUiTest(config: TestConfig) : PaparazziScreenTest(config) {

    @Test
    fun topicsContentScreenPreviewTest() {
        screenshotTest { TopicsContentScreenPreview() }
    }

    @Test
    fun topicsContentScrollableScreenPreviewTest() {
        screenshotTest { TopicsContentScrollableScreenPreview() }
    }

    @Test
    fun topicsErrorScreenPreviewTest() {
        screenshotTest { TopicsErrorScreenPreview() }
    }

    @Test
    fun topicsContentScreenDarkModePreviewTest() {
        screenshotTest { TopicsContentScreenDarkModePreview() }
    }

    @Test
    fun topicsContentScrollableScreenDarkModePreviewTest() {
        screenshotTest { TopicsContentScrollableScreenDarkModePreview() }
    }

    @Test
    fun topicsErrorScreenDarkModePreviewTest() {
        screenshotTest { TopicsErrorScreenDarkModePreview() }
    }
}
