package com.enderium.smoothmount.client.util;

import com.enderium.smoothmount.state.CameraModifier;
import net.minecraft.world.phys.Vec3;
import org.joml.Quaternionf;

import java.util.function.Supplier;

public class CameraLerpUtils {


    public static Supplier<Vec3> smoothToPosition(CameraModifier modifier, Vec3 startPos, final long endTime) {
        return new Supplier<>() {
            private final long startTime = System.nanoTime();
            final long endTimeLong = endTime * 1_000_000L;
            final double endTimeFloat = endTimeLong;

            @Override
            public Vec3 get() {
                long time = System.nanoTime() - startTime;
                if (time > endTimeLong) modifier.smoothMount$setSupplierPosition(null);
                double d = time / endTimeFloat;
                if (d>1)d=1;
                return startPos.lerp(modifier.smoothMount$lastPosition(), d).add(0, Math.sin(d * Math.PI) * 0.5, 0);
            }
        };
    }


    public static Supplier<Quaternionf> smoothToRotation(CameraModifier modifier, Quaternionf startRot, final long endTime) {
        return new Supplier<>() {
            private static final double fPI = 1.5707963267948966;
            private final long startTime = System.nanoTime();
            final long endTimeLong = endTime * 1_000_000L;
            final double endTimeFloat = endTimeLong;
            private final Quaternionf mathRot = new Quaternionf();

            @Override
            public Quaternionf get() {
                long time = System.nanoTime() - startTime;
                if (time > endTimeLong) modifier.smoothMount$setSupplierRotation(null);
                return mathRot.set(startRot).nlerp(modifier.smoothMount$lastRotation(), (float) org.joml.Math.sin((time / endTimeFloat) * fPI));
            }
        };
    }

}
