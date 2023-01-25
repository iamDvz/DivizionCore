package ru.iamdvz.core.utils

import kotlin.math.roundToInt

object BarUtil {
    @JvmStatic
    fun makeBar(empty: String, full: String, size: Int, max: Double, current: Double): String =
        (full.repeat((size * current / max).roundToInt()) + empty.repeat((size * (1 - current / max)).roundToInt()))
}