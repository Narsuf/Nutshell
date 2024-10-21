package com.n27.nutshell.presentation

import androidx.annotation.StringRes
import org.n27.nutshell.common.presentation.model.Error

fun getError(
    @StringRes title: Int = org.n27.nutshell.R.string.generic_error_title,
    @StringRes description: Int = org.n27.nutshell.R.string.generic_error_description
) = Error(
    title = title,
    description = description
)
