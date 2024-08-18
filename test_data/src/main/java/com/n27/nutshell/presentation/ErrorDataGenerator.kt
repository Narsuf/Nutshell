package com.n27.nutshell.presentation

import org.n27.nutshell.presentation.common.model.Error

fun getError() = Error(
    title = org.n27.nutshell.R.string.generic_error_title,
    description = org.n27.nutshell.R.string.generic_error_description
)