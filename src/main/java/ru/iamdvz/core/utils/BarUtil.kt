package ru.iamdvz.core.utils

import kotlin.math.roundToInt

object BarUtil {
    @JvmStatic
    fun makeBar(empty: String, full: String, size: Int, max: Double, current: Double): String =
        (full.repeat((size * current / max).roundToInt()) + empty.repeat((size * (1 - current / max)).roundToInt()))
    @JvmStatic
    fun makeBar(empty: String, full: String, size: Int, max: Double, current: Double, firstSymbol: String): String =
        firstSymbol+makeBar(empty, full, size, max, current).substring(1, -1)
    @JvmStatic
    fun makeBar(empty: String, full: String, size: Int, max: Double, current: Double, firstSymbol: String, lastSymbol: String): String =
        firstSymbol+makeBar(empty, full, size, max, current).substring(1, -2) + lastSymbol
}