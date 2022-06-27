package com.ipsoft.packtrack.common.utils.validator

import com.ipsoft.packtrack.R

interface IValidator {

    fun validate(): ValidateResult

    companion object {
        fun validate(vararg validators: IValidator): ValidateResult {
            validators.forEach {
                val result = it.validate()
                if (!result.isSuccess)
                    return result
            }
            return ValidateResult(true, R.string.text_validation_success)
        }
    }
}