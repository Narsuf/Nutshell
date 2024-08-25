package org.n27.nutshell.presentation.topics

import org.junit.Test
import org.n27.nutshell.presentation.topics.composables.TopicsContentScreenPreview
import org.n27.nutshell.presentation.topics.composables.TopicsErrorScreenPreview
import org.n27.nutshell.presentation.topics.composables.TopicsLoadingScreenPreview
import org.n27.nutshell.screenshot.PaparazziScreenTest
import org.n27.nutshell.screenshot.TestConfig

class TopicsUiTest(config: TestConfig) : PaparazziScreenTest(config) {

    @Test
    fun sampleTopicsContentScreenPreviewTest() {
        screenshotTest { TopicsContentScreenPreview() }
    }

    @Test
    fun sampleTopicsErrorScreenPreviewTest() {
        screenshotTest { TopicsErrorScreenPreview() }
    }

    @Test
    fun sampleTopicsLoadingScreenPreviewTest() {
        screenshotTest { TopicsLoadingScreenPreview() }
    }
}
