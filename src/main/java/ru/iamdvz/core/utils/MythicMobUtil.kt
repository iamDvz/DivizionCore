package ru.iamdvz.core.utils

import io.lumine.mythic.bukkit.MythicBukkit
import org.bukkit.entity.Entity

object MythicMobUtil {
    private val api = MythicBukkit.inst().apiHelper
    fun isMythicMob(entity: Entity?): Boolean {
        return if (entity != null) {
            api.isMythicMob(entity)
        } else false
    }

    fun getMythicMobDisplayName(entity: Entity?): String? = api.getMythicMobInstance(entity)?.displayName

    fun getMythicMobLevel(entity: Entity?): Double? = api.getMythicMobInstance(entity)?.level

    fun getMythicMobCurrentHealth(entity: Entity?): Double = api.getMythicMobInstance(entity).entity.health

    fun getMythicMobConfigName(entity: Entity?): String = api.getMythicMobInstance(entity).type.internalName

    fun getMythicMobMaxHealth(entity: Entity?): Double = api.getMythicMobInstance(entity).entity.maxHealth

}