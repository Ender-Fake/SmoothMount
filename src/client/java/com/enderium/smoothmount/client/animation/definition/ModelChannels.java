package com.enderium.smoothmount.client.animation.definition;

import org.joml.Vector3f;

public class ModelChannels {
    private static final float DEGREES_TO_RADIANS = 0.017453292519943295f;

    public static Vector3f posVec(float f, float g, float h) {
        return new Vector3f(f, -g, h);
    }

    public static Vector3f degreeVec(float f, float g, float h) {
        return new Vector3f(f * DEGREES_TO_RADIANS, g * DEGREES_TO_RADIANS, h * DEGREES_TO_RADIANS);
    }

    public static Vector3f scaleVec(float d, float e, float f) {
        return new Vector3f(d - 1.0f, e - 1.0f, f - 1.0f);
    }

}
