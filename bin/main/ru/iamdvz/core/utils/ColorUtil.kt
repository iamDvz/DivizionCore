package ru.iamdvz.core.utils

import org.bukkit.Color

object ColorUtil {
    fun hexToRGBColor(hex: String?): Color? {
        return if (hex == null || hex.length < 6) null else try {
            val r = hex.substring(0, 2).toInt(16)
            val g = hex.substring(2, 4).toInt(16)
            val b = hex.substring(4, 6).toInt(16)
            Color.fromRGB(r, g, b)
        } catch (ignored: Exception) {
            null
        }
    }
}