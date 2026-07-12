package com.enderium.smoothmount.state;

import com.enderium.smoothmount.client.render.camera.SmoothCameraModifier;
import net.minecraft.world.phys.Vec3;

public interface CameraModifier {

    SmoothCameraModifier smoothMount$getSmoothModifier();

    Vec3 smoothMount$getSourcePosition();

    Vec3 smoothMount$getPosition();

    void smoothMount$setPosition(Vec3 pos);

    float smoothMount$getYaw();

    float smoothMount$getPitch();

    void smoothMount$setRotation(float yaw, float pitch);


}
