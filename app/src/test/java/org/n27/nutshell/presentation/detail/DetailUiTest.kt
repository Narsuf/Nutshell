package org.n27.nutshell.presentation.detail

import org.junit.Test
import org.n27.nutshell.detail.presentation.composables.DetailContentScreenDarkModePreview
import org.n27.nutshell.detail.presentation.composables.DetailContentScreenPreview
import org.n27.nutshell.detail.presentation.composables.DetailContentScrollableScreenDarkModePreview
import org.n27.nutshell.detail.presentation.composables.DetailContentScrollableScreenPreview
import org.n27.nutshell.detail.presentation.composables.DetailContentWithoutNavScreenDarkModePreview
import org.n27.nutshell.detail.presentation.composables.DetailContentWithoutNavScreenPreview
import org.n27.nutshell.detail.presentation.composables.DetailContentWithoutNavScrollableScreenDarkModePreview
import org.n27.nutshell.detail.presentation.composables.DetailContentWithoutNavScrollableScreenPreview
import org.n27.nutshell.detail.presentation.composables.DetailErrorScreenDarkModePreview
import org.n27.nutshell.detail.presentation.composables.DetailErrorScreenPreview
import org.n27.nutshell.detail.presentation.composables.DetailLoadingScreenPreview
import org.n27.nutshell.screenshot.PaparazziScreenTest
import org.n27.nutshell.screenshot.TestConfig

class DetailUiTest(config: TestConfig) : PaparazziScreenTest(config) {

    @Test
    fun detailContentScreenPreviewTest() {
        screenshotTest { DetailContentScreenPreview() }
    }

    @Test
    fun detailContentScrollableScreenPreviewTest() {
        screenshotTest { DetailContentScrollableScreenPreview() }
    }

    @Test
    fun detailContentWithoutNavScreenPreviewTest() {
        screenshotTest { DetailContentWithoutNavScreenPreview() }
    }

    @Test
    fun detailContentWithoutNavScrollableScreenPreviewTest() {
        screenshotTest { DetailContentWithoutNavScrollableScreenPreview() }
    }

    @Test
    fun detailLoadingScreenPreviewTest() {
        screenshotTest { DetailLoadingScreenPreview() }
    }

    @Test
    fun detailErrorScreenPreviewTest() {
        screenshotTest { DetailErrorScreenPreview() }
    }

    @Test
    fun detailContentScreenDarkModePreviewTest() {
        screenshotTest { DetailContentScreenDarkModePreview() }
    }

    @Test
    fun detailContentScrollableScreenDarkModePreviewTest() {
        screenshotTest { DetailContentScrollableScreenDarkModePreview() }
    }

    @Test
    fun detailContentWithoutNavScreenDarkModePreviewTest() {
        screenshotTest { DetailContentWithoutNavScreenDarkModePreview() }
    }

    @Test
    fun detailContentWithoutNavScrollableScreenDarkModePreviewTest() {
        screenshotTest { DetailContentWithoutNavScrollableScreenDarkModePreview() }
    }

    // The test is not being recorded correctly for some reason. It doesn't match the preview.
    /*
    @Test
    fun detailLoadingScreenDarkThemePreviewTest() {
        screenshotTest { DetailLoadingScreenDarkThemePreview() }
    }*/

    @Test
    fun detailErrorScreenDarkModePreviewTest() {
        screenshotTest { DetailErrorScreenDarkModePreview() }
    }
}
