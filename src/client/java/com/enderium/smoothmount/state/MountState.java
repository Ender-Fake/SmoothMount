package com.enderium.smoothmount.state;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;

import java.util.Optional;

public interface MountState {

    Vec3 getPlayerPos(float delta);

    void setPlayerPos(Vec3 vec);

    Vec3 getLastPosition();

    void setLastPosition(Vec3 vec);

    default void setLastPosition(double x, double y, double z) {
        setLastPosition(new Vec3(x, y, z));
    }

    float getMountYaw();

    void setMountYaw(float yaw);

    Optional<Entity> getLastVehicle();

    void setLastVehicle(Entity vehicle);

    default Vec3 getVehiclePos(float d) {
        Optional<Entity> vehicle = getLastVehicle();
        return vehicle.map(entity -> entity.getPosition(d)).orElse(Vec3.ZERO);
    }

    Vec3 smoothMount$getPassengerAttachmentPoint(Entity entity, float d);

    Vec3 smoothMount$getVehicleAttachmentPoint(Entity entity);

}
