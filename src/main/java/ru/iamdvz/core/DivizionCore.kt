package ru.iamdvz.core

import nl.sbdeveloper.vehiclesplus.VehiclesPlusPluginManager
import nl.sbdeveloper.vehiclesplus.api.VehiclesPlusAPI
import nl.sbdeveloper.vehiclesplus.api.vehicles.Vehicle
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import ru.iamdvz.core.api.ApiVehiclesPlus
import ru.iamdvz.core.placeholders.LoreGrabberPlaceholder
import ru.iamdvz.core.placeholders.NameGrabberPlaceholder
import ru.iamdvz.core.utils.UuidUtil
import java.util.*

class DivizionCore : JavaPlugin() {
    override fun onEnable() {
        this.logger.info("Hello! Have a good day.")
        if(Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            this.logger.info("Enabling LoreGrabberPlaceholder")
            LoreGrabberPlaceholder(this).register();
            this.logger.info("Enabling NameGrabberPlaceholder")
            NameGrabberPlaceholder(this).register();
        }
    }

    override fun onDisable() {
        this.logger.info("Bye-bye!")
    }

    //fun getVehiclesPlusAPI(): MutableMap<UUID, Vehicle>? = VehiclesPlusAPI.getVehicles();
    fun getApiVehiclesPlus(): ApiVehiclesPlus = ApiVehiclesPlus().instance
    fun getUuidUtil(): UuidUtil = UuidUtil().instance
}