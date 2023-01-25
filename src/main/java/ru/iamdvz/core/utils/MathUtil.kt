package ru.iamdvz.core.utils

import kotlin.math.round

object MathUtil {
    fun percentage(x: Double, y: Double, round: Boolean = false) = if (!round) (100/(x/y)) else round(100/(x/y))
}