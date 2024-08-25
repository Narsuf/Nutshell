package org.n27.nutshell.screenshot

import androidx.compose.runtime.Composable
import app.cash.paparazzi.DeviceConfig
import app.cash.paparazzi.Paparazzi
import com.android.ide.common.rendering.api.SessionParams
import com.android.resources.NightMode
import org.junit.Rule
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
abstract class PaparazziScreenTest(config: TestConfig) {

    @get:Rule
    val paparazzi = Paparazzi(
        maxPercentDifference = 0.0,
        showSystemUi = false,
        deviceConfig = when (config.device) {
            Device.PIXEL_6 -> DeviceConfig.PIXEL_6
        }.copy(
            nightMode = config.nightMode,
            fontScale = config.fontScale,
        ),
        renderingMode = SessionParams.RenderingMode.NORMAL,
    )
    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "{0}")
        fun data(): Collection<Array<Any>> {
            val devices = listOf(Device.PIXEL_6)
            val fontScales = listOf(1f)
            val modes = listOf(NightMode.NOTNIGHT)

            return devices.flatMap { device ->
                fontScales.flatMap { fontScale ->
                    modes.map { mode ->
                        arrayOf(TestConfig(device, mode, fontScale))
                    }
                }
            }
        }
    }

    fun screenshotTest(content: @Composable () -> Unit) {
        paparazzi.snapshot { content.invoke() }
    }
}