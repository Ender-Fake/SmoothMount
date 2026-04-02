package com.enderium.smoothmount.state;

import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Quaternionf;

import java.util.function.Supplier;

public interface CameraModifier {

    Vec3 smoothMount$lastPosition();

    Quaternionf smoothMount$lastRotation();

    Vec3 smoothMount$realPosition();

    Quaternionf smoothMount$realRotation();

    Supplier<Vec3> smoothMount$getSupplierPosition();

    void smoothMount$setSupplierPosition(@Nullable Supplier<@NotNull Vec3> supplier);

    Supplier<Quaternionf> smoothMount$getSupplierRotation();

    void smoothMount$setSupplierRotation(@Nullable Supplier<@NotNull Quaternionf> supplier);

}
