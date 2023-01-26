package ru.iamdvz.core.utils

import java.util.*

class UuidUtil {
    val instance: UuidUtil
        get() = this

    fun getUuidByString(str: String?): UUID {
        return UUID.fromString(str)
    }
}