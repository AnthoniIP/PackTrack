package com.ipsoft.packtrack.common.utils.validator

import android.text.TextUtils
import com.ipsoft.packtrack.R
import com.ipsoft.packtrack.common.Constants.CORREIOS_CODE_REGEX

class CorreiosCodeValidator(private val code: String) : IValidator {
    override fun validate(): ValidateResult {
        val codeRegex = Regex(CORREIOS_CODE_REGEX)
        val isValid =
            !TextUtils.isEmpty(code) && codeRegex.matches(code)
        return ValidateResult(
            isValid,
            if (isValid) R.string.text_validation_success else R.string.invalid_code
        )
    }
}