package com.enderium.smoothmount.client.enity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.camel.Camel;
import net.minecraft.world.entity.animal.equine.AbstractHorse;
import net.minecraft.world.entity.animal.pig.Pig;
import net.minecraft.world.entity.vehicle.VehicleEntity;
import net.minecraft.world.entity.vehicle.minecart.Minecart;

public class VehicleTypes {

    //private static List<EntityType>

    public static boolean isCorrectVehicle(Entity entity) {
        if (entity instanceof Camel)return false;
        if (entity instanceof VehicleEntity)return false;
        if (entity instanceof AbstractHorse)return true;
        if (entity instanceof Pig)return true;

        return false;
    }

}
