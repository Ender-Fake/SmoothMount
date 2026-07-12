package com.enderium.smoothmount.client.render.camera;

import com.enderium.smoothmount.state.CameraModifier;
import net.minecraft.world.phys.Vec3;
import org.joml.Math;

public class SmoothCameraModifier {
    private static final float fPI = 1.5707963267948966f;

    private final CameraModifier camera;

    private long startTime;
    private long endTime = -1;
    private double duration;
    private float startYaw;
    private float startPitch;
    private Vec3 startPos;

    public SmoothCameraModifier(CameraModifier camera) {
        this.camera = camera;
    }


    public void computeAndSet() {
        long time = System.nanoTime();
        if (time > endTime) return;
        float alpha = (float) ((time - startTime) / duration);
        float sin = Math.sin(alpha * fPI);
        Vec3 pos = camera.smoothMount$getPosition();
        float y = camera.smoothMount$getYaw();
        float p = camera.smoothMount$getPitch();

        camera.smoothMount$setPosition(startPos.lerp(pos, alpha).add(0, Math.sin(alpha * Math.PI) * 0.5, 0));
        float currentYaw = startYaw + deltaYaw(startYaw, y) * sin;
        camera.smoothMount$setRotation(currentYaw, lerp(alpha, startPitch, p));

    }

    public void start(long duration, Vec3 pos, float yaw, float pitch) {
        this.startYaw = yaw;
        this.startPitch = pitch;
        this.startPos = pos;
        this.duration = duration * 1_000_000;
        this.endTime = (this.startTime = System.nanoTime()) + (duration * 1_000_000);

    }


    public static float deltaYaw(float from, float to) {

        float fromNorm = normalizeYaw(from);
        float toNorm = normalizeYaw(to);

        float delta = toNorm - fromNorm;

        if (delta > 180.0f) delta -= 360.0f;
        if (delta < -180.0f) delta += 360.0f;

        return delta;
    }

    public static float normalizeYaw(float angle) {
        angle = angle % 360.0f;
        if (angle > 180.0f) angle -= 360.0f;
        if (angle < -180.0f) angle += 360.0f;
        return angle;
    }


    private float lerp(float alpha, float start, float end) {
        return start + (end - start) * alpha;
    }

    private double lerp(double alpha, double start, double end) {
        return start + (end - start) * alpha;
    }

}
