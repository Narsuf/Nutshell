package org.n27.nutshell.common.presentation.mapping

import org.n27.nutshell.R
import org.n27.nutshell.common.Constants.NO_INTERNET_CONNECTION
import org.n27.nutshell.common.presentation.model.Error as MyError

fun Throwable.toError() = message?.let {
    when (it) {
        NO_INTERNET_CONNECTION -> MyError(
            title = R.string.no_internet_error_title,
            description = R.string.no_internet_error_description
        )

        else -> MyError()
    }
} ?: MyError()
