package org.n27.nutshell.presentation.topics

import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.crashlytics.FirebaseCrashlytics
import org.n27.nutshell.extensions.trackItem
import org.n27.nutshell.extensions.trackScreen
import org.n27.nutshell.presentation.common.Tracker
import org.n27.nutshell.presentation.topics.TopicsTracker.Action.RETRY_BUTTON_CLICK
import org.n27.nutshell.presentation.topics.TopicsTracker.Action.SCREEN_NAME
import org.n27.nutshell.presentation.topics.TopicsTracker.Action.SCREEN_VIEW
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