package ru.iamdvz.core.utils

import org.bukkit.util.Vector

class VectorUtil {
    companion object {
        // thanks to https://github.com/Slikey/EffectLib/blob/master/src/main/java/de/slikey/effectlib/util/VectorUtils.java
        @JvmStatic
        fun rotateVector(v: Vector, yawDegrees: Float, pitchDegrees: Float): Vector {
            val yaw = Math.toRadians((-1 * (yawDegrees + 90)).toDouble())
            val pitch = Math.toRadians(-pitchDegrees.toDouble())
            val cosYaw = Math.cos(yaw)
            val cosPitch = Math.cos(pitch)
            val sinYaw = Math.sin(yaw)
            val sinPitch = Math.sin(pitch)
            var x: Double
            val y: Double
            val z: Double

            // Z_Axis rotation (Pitch)
            x = v.x * cosPitch - v.y * sinPitch
            y = v.x * sinPitch + v.y * cosPitch

            // Y_Axis rotation (Yaw)
            z = v.z * cosYaw - x * sinYaw
            x = v.z * sinYaw + x * cosYaw
            return Vector(x, y, z)
        }
    }
}