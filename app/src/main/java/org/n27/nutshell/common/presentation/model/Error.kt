package org.n27.nutshell.common.presentation.model

import androidx.annotation.StringRes
import org.n27.nutshell.R

data class Error(
    @StringRes val title: Int = R.string.generic_error_title,
    @StringRes val description: Int = R.string.generic_error_description
)
