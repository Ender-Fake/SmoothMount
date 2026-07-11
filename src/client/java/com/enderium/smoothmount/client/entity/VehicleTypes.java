package com.enderium.smoothmount.client.entity;

import com.enderium.smoothmount.client.model.animation.entity.AnimationType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.camel.Camel;
import net.minecraft.world.entity.animal.equine.AbstractHorse;
import net.minecraft.world.entity.animal.pig.Pig;
import net.minecraft.world.entity.vehicle.VehicleEntity;

public class VehicleTypes {

    //private static List<EntityType>

    public static boolean isCorrectVehicle(Entity entity) {
        if (entity instanceof Camel) return false;
        if (entity instanceof VehicleEntity) return false;
        if (entity instanceof AbstractHorse) return true;
        return entity instanceof Pig;
    }

    public static AnimationType getType(Entity entity){
        if (entity instanceof Pig)return AnimationType.DefaultAnimation;
        if (entity instanceof Camel) return null;
        if (entity instanceof VehicleEntity) return AnimationType.MinecartAnimation;
        if (entity instanceof AbstractHorse) return AnimationType.DefaultAnimation;
        return null;
    }


}
