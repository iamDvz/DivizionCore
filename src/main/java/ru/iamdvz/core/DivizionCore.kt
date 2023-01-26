package ru.iamdvz.core

import me.legofreak107.vehiclesplus.vehicles.api.VehiclesPlusAPI
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import ru.iamdvz.core.api.ApiVehiclesPlus
import ru.iamdvz.core.placeholders.LoreGrabberPlaceholder
import ru.iamdvz.core.placeholders.NameGrabberPlaceholder
import ru.iamdvz.core.utils.UuidUtil

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

    fun getVehiclesPlusAPI(): VehiclesPlusAPI{
        return VehiclesPlusAPI.getInstance()
    }
    fun getApiVehiclesPlus(): ApiVehiclesPlus {
        return ApiVehiclesPlus().instance
    }
    fun getUuidUtil(): UuidUtil {
        return UuidUtil().instance
    }
}