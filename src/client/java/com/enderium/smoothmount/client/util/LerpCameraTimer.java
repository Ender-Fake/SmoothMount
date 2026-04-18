package com.enderium.smoothmount.client.util;

import net.minecraft.world.phys.Vec3;
import org.joml.Quaternionf;

public abstract class LerpCameraTimer {

    protected float time;
    protected float lengthTime;
    protected float deltaTime;

    public LerpCameraTimer(float lengthTime) {
        this.lengthTime = lengthTime;
    }


    public Vec3 lerpPosition(Vec3 end) {
        return lerpPosition(end, deltaTime);
    }

    protected abstract Vec3 lerpPosition(Vec3 end, float delta);

    public Quaternionf lerpRotation(Quaternionf end) {
        return lerpRotation(end, deltaTime);
    }

    protected abstract Quaternionf lerpRotation(Quaternionf end, float delta);


    public void increment(float delta) {
        if (lengthTime <= 0) {
            deltaTime = 1;
            return;
        }
        time += delta;
        deltaTime = time / lengthTime;
    }


    public static float ofSeconds(float ticks) {
        return ticks * 20;
    }

}
