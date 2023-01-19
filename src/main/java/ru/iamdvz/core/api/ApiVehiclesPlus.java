package ru.iamdvz.core.api;

import me.legofreak107.vehiclesplus.vehicles.api.VehiclesPlusAPI;
import me.legofreak107.vehiclesplus.vehicles.vehicles.objects.SpawnedVehicle;
import me.legofreak107.vehiclesplus.vehicles.vehicles.objects.StorageVehicle;
import org.bukkit.entity.Player;

import java.util.Map;
import java.util.UUID;

public class ApiVehiclesPlus {
    public ApiVehiclesPlus getInstance() {
        return this;
    }

    public SpawnedVehicle getPlayerVehicle(Player p) {
        UUID pUUID = p.getUniqueId();
        for (var entrySet : VehiclesPlusAPI.getVehicleManager().getPlayerVehicleHashMap().entrySet()) {
            //if (entrySet.getKey().equals(pUUID)) {
                for (var vehicle : entrySet.getValue()) {
                    if (vehicle.getSpawnedVehicle() != null) {
                        for (var entity : vehicle.getSpawnedVehicle().getHolder().getNearbyEntities(0.5, 0.5, 0.5)) {
                            if (entity.getUniqueId().equals(pUUID)) {
                                return vehicle.getSpawnedVehicle();
                            }
                        }
                    }
                //}
            }
        }
        return null;
    }

}
