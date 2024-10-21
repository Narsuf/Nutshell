package org.n27.nutshell.topics.presentation

import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.crashlytics.FirebaseCrashlytics
import org.n27.nutshell.common.presentation.extensions.trackItem
import org.n27.nutshell.common.presentation.extensions.trackScreen
import org.n27.nutshell.common.presentation.tracking.Tracker
import org.n27.nutshell.topics.presentation.TopicsTracker.Action.RETRY_BUTTON_CLICK
import org.n27.nutshell.topics.presentation.TopicsTracker.Action.SCREEN_NAME
import org.n27.nutshell.topics.presentation.TopicsTracker.Action.SCREEN_VIEW
import javax.inject.Inject

class TopicsTracker @Inject constructor(
    crashlytics: FirebaseCrashlytics,
    private val analytics: FirebaseAnalytics,
) : Tracker(crashlytics) {

    fun trackScreenView() { analytics.trackScreen(SCREEN_VIEW) }

    fun trackRetryButton() { analytics.trackItem(RETRY_BUTTON_CLICK) }

    fun trackItem(name: String) {
        analytics.trackItem("${SCREEN_NAME}_${name}_item.click")
    }

    private object Action {
        const val SCREEN_NAME = "topics_screen"
        const val SCREEN_VIEW = "$SCREEN_NAME.view"
        const val RETRY_BUTTON_CLICK = "${SCREEN_NAME}_retry_button.click"
    }
}
