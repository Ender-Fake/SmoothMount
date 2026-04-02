package com.enderium.smoothmount.mixin.client;

import com.enderium.smoothmount.state.CameraModifier;
import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.Camera;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Slice;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.text.NumberFormat;
import java.util.function.Supplier;

@Debug(export = true)
@Mixin(Camera.class)
public abstract class CameraMixin implements CameraModifier {

    @Shadow
    @Final
    private Quaternionf rotation;
    @Shadow
    private Vec3 position;

    @Shadow
    protected abstract void setPosition(Vec3 vec3);

    @Shadow
    protected abstract void setRotation(float f, float g);

    @Shadow
    private float xRot;
    @Shadow
    private float yRot;

    @Unique
    private Vec3 lastPos = Vec3.ZERO;
    @Unique
    private Quaternionf lastRotation = new Quaternionf();

    @Unique
    private Supplier<Vec3> positionSupplier = null;
    @Unique
    private Supplier<Quaternionf> rotationSupplier = null;


    @Definition(id = "bl", local = @Local(type = boolean.class, ordinal = 0, argsOnly = true))
    @Expression(value = "bl")
    @Inject(method = "setup", at = @At(value = "MIXINEXTRAS:EXPRESSION"), slice = @Slice(from = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/Entity;isPassenger()Z")))
    //@Inject(method = "setup", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/Entity;isPassenger()Z", ordinal = 0, shift = At.Shift.AFTER, by = 1), slice = @Slice(from = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/Entity;isPassenger()Z")))
    public void lerpPos(Level level, Entity entity, boolean bl, boolean bl2, float f, CallbackInfo ci) {
        lastPos = position;
        lastRotation.set(rotation);
        if (positionSupplier != null) setPosition(positionSupplier.get());
        if (rotationSupplier != null) smoothMount$setRotation(rotationSupplier.get());


    }


    @Unique
    private final Vector3f eulerAngles = new Vector3f();

    @Unique
    public void smoothMount$setRotation(Quaternionf rotation) {
        //this.rotation.set(rotation);
        //rotation.getEulerAnglesXYZ(eulerAngles);
        rotation.getEulerAnglesYXZ(eulerAngles);
        setRotation(-(180+eulerAngles.y*57.29577951308232f),-eulerAngles.x*57.29577951308232f);

    }

    @Override
    public Vec3 smoothMount$realPosition() {
        return position;
    }

    @Override
    public Quaternionf smoothMount$realRotation() {
        return rotation;
    }

    @Override
    public Supplier<Vec3> smoothMount$getSupplierPosition() {
        return positionSupplier;
    }

    @Override
    public void smoothMount$setSupplierPosition(@Nullable Supplier<@NotNull Vec3> supplier) {
        positionSupplier = supplier;
    }

    @Override
    public Supplier<Quaternionf> smoothMount$getSupplierRotation() {
        return rotationSupplier;
    }

    @Override
    public void smoothMount$setSupplierRotation(@Nullable Supplier<@NotNull Quaternionf> supplier) {
        rotationSupplier = supplier;
    }

    @Override
    public Vec3 smoothMount$lastPosition() {
        return lastPos;
    }

    @Override
    public Quaternionf smoothMount$lastRotation() {
        return lastRotation;
    }
}
