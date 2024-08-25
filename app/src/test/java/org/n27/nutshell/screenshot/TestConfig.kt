package org.n27.nutshell.screenshot

import com.android.resources.NightMode

data class TestConfig(
    val device: Device,
    val nightMode: NightMode,
    val fontScale: Float,
) {

    override fun toString() = "device=$device, nightMode=$nightMode, fontScale=$fontScale"
}

enum class Device {
    PIXEL_6
}
