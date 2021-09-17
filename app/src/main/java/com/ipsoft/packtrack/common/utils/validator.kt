package com.ipsoft.packtrack.common.utils

fun String.validateTrackCode(): Boolean {

    if (this.length < 13) {
        return false
    } else {
        return true
    }

}