package com.ipsoft.packtrack.common.utils.validator

import androidx.annotation.StringRes

data class ValidateResult(
    val isSuccess: Boolean,
    @StringRes val message: Int
)
