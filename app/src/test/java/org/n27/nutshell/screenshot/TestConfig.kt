package org.n27.nutshell.screenshot

import com.android.resources.NightMode

data class TestConfig(
    val device: TestDevice,
    val nightMode: NightMode,
    val fontScale: Float,
) {
    override fun toString() = "device=$device, nightMode=$nightMode, fontScale=$fontScale"
}

enum class TestDevice {
    PIXEL_6
}
