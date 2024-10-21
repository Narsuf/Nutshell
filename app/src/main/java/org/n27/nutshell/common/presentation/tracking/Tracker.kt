package org.n27.nutshell.common.presentation.tracking

import com.google.firebase.crashlytics.FirebaseCrashlytics

open class Tracker(private val crashlytics: FirebaseCrashlytics) {

    fun trackError(throwable: Throwable) { crashlytics.recordException(throwable) }
}
