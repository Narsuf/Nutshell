package org.n27.nutshell.presentation.common.mapping

import org.n27.nutshell.Constants.NO_INTERNET_CONNECTION
import org.n27.nutshell.R
import org.n27.nutshell.presentation.common.model.Error as MyError

fun Throwable.toError() = message?.let {
    when (it) {
        NO_INTERNET_CONNECTION -> MyError(
            title = R.string.no_internet_error_title,
            description = R.string.no_internet_error_description
        )

        else -> genericError()
    }
} ?: genericError()

private fun genericError() = MyError(
    title = R.string.generic_error_title,
    description = R.string.generic_error_description
)