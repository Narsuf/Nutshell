package org.n27.nutshell.common.presentation.extensions

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

inline fun <reified T> Flow<T>.observeOnLifecycle(
    lifecycleOwner: LifecycleOwner,
    distinctUntilChanged: Boolean = false,
    noinline action: suspend (T) -> Unit
): Job = lifecycleOwner.lifecycleScope.launch {
    flowWithLifecycle(lifecycleOwner.lifecycle, Lifecycle.State.STARTED)
        .let { if (distinctUntilChanged) it.distinctUntilChanged() else it }
        .collect { action(it) }
}
