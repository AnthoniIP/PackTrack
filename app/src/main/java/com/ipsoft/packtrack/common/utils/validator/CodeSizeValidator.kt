package com.ipsoft.packtrack.common.utils.validator

import android.text.TextUtils
import com.ipsoft.packtrack.R
import com.ipsoft.packtrack.common.Constants

class CodeSizeValidator(private val code: String) : IValidator {
    override fun validate(): ValidateResult {
        val isValid = code.length <= Constants.CODE_SIZE
        return ValidateResult(
            isValid,
            if (isValid) R.string.text_validation_success else R.string.invalid_code
        )
    }
}