package org.n27.nutshell.extensions

import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.logEvent

fun FirebaseAnalytics.trackScreen(name: String) {
    logEvent(FirebaseAnalytics.Event.SCREEN_VIEW) {
        param(FirebaseAnalytics.Param.SCREEN_NAME, name)
    }
}

fun FirebaseAnalytics.trackItem(name: String) {
    logEvent(FirebaseAnalytics.Event.SELECT_ITEM) {
        param(FirebaseAnalytics.Param.ITEM_NAME, name)
    }
}
