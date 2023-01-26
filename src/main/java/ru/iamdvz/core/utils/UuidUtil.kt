package ru.iamdvz.core.utils;

import ru.iamdvz.core.api.ApiVehiclesPlus;

import java.util.UUID;

public class UuidUtil {
    public UuidUtil getInstance() {
        return this;
    }
    public UUID getUuidByString(String str) {
        return UUID.fromString(str);
    }
}
