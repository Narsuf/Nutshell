package org.n27.nutshell.presentation.common.model

import androidx.annotation.StringRes

data class Error(
    @StringRes val title: Int,
    @StringRes val description: Int
)