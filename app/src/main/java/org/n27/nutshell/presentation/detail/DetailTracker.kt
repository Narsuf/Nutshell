package org.n27.nutshell.presentation.detail

import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.crashlytics.FirebaseCrashlytics
import org.n27.nutshell.extensions.trackItem
import org.n27.nutshell.extensions.trackScreen
import org.n27.nutshell.presentation.common.tracking.Tracker
import org.n27.nutshell.presentation.detail.DetailTracker.Action.BACK_BUTTON_CLICK
import org.n27.nutshell.presentation.detail.DetailTracker.Action.RETRY_BUTTON_CLICK
import org.n27.nutshell.presentation.detail.DetailTracker.Action.SCREEN_NAME
import org.n27.nutshell.presentation.detail.DetailTracker.Action.SOURCE_BUTTON_CLICK
import javax.inject.Inject

class DetailTracker @Inject constructor(
    crashlytics: FirebaseCrashlytics,
    private val analytics: FirebaseAnalytics,
) : Tracker(crashlytics) {

    fun trackScreenView(key: String) {
        analytics.trackScreen("${SCREEN_NAME}_$key.view")
    }

    fun trackBackClick(key: String) {
        analytics.trackItem("${SCREEN_NAME}_${key}_$BACK_BUTTON_CLICK")
    }

    fun trackRetryButton(key: String) {
        analytics.trackItem("${SCREEN_NAME}_${key}_$RETRY_BUTTON_CLICK")
    }

    fun trackSourceButton(key: String, navScreen: String?) {
        navScreen?.let {
            analytics.trackItem(
                name = "${SCREEN_NAME}_${key}_${it.lowercase()}_$SOURCE_BUTTON_CLICK"
            )
        } ?: trackSourceButton(key)
    }

    private fun trackSourceButton(key: String) {
        analytics.trackItem("${SCREEN_NAME}_${key}_$SOURCE_BUTTON_CLICK")
    }

    fun trackNavClick(key: String, navItem: String) {
        analytics.trackItem(
            name = "${SCREEN_NAME}_${key}_${navItem.lowercase()}_button.click"
        )
    }

    private object Action {
        const val SCREEN_NAME = "detail_screen"
        const val BACK_BUTTON_CLICK = "back_button.click"
        const val RETRY_BUTTON_CLICK = "retry_button.click"
        const val SOURCE_BUTTON_CLICK = "source_button.click"
    }
}
