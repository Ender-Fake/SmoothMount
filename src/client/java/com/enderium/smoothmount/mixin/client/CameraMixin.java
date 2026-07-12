package com.enderium.smoothmount.mixin.client;

import com.enderium.smoothmount.client.render.camera.SmoothCameraModifier;
import com.enderium.smoothmount.state.CameraModifier;
import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.Camera;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Slice;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

//@Debug(export = true)
@Mixin(Camera.class)
public abstract class CameraMixin implements CameraModifier {

    @Shadow
    private Vec3 position;

    @Shadow
    protected abstract void setPosition(Vec3 vec3);

    @Shadow
    protected abstract void setRotation(float f, float g);

    @Shadow
    public abstract float yRot();

    @Shadow
    public abstract float xRot();

    @Unique
    private final SmoothCameraModifier smoothMount$smoothModifier = new SmoothCameraModifier(this);
    @Unique
    private Vec3 smoothMount$sourcePosition;


    @Definition(id = "bl", local = @Local(type = boolean.class, ordinal = 0, argsOnly = true))
    @Expression(value = "bl")
    @Inject(method = "setup", at = @At(value = "MIXINEXTRAS:EXPRESSION"), slice = @Slice(from = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/Entity;isPassenger()Z")))
    //@Inject(method = "setup", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/Entity;isPassenger()Z", ordinal = 0, shift = At.Shift.AFTER, by = 1), slice = @Slice(from = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/Entity;isPassenger()Z")))
    public void lerpPos(Level level, Entity entity, boolean bl, boolean bl2, float f, CallbackInfo ci) {

        smoothMount$sourcePosition = position;

        smoothMount$smoothModifier.computeAndSet();


    }

    @Override
    public SmoothCameraModifier smoothMount$getSmoothModifier() {
        return smoothMount$smoothModifier;
    }

    @Override
    public Vec3 smoothMount$getSourcePosition() {
        return smoothMount$sourcePosition;
    }

    @Override
    public Vec3 smoothMount$getPosition() {
        return position;
    }

    @Override
    public void smoothMount$setPosition(Vec3 pos) {
        setPosition(pos);
    }

    @Override
    public float smoothMount$getYaw() {
        return yRot();
    }

    @Override
    public float smoothMount$getPitch() {
        return xRot();
    }

    @Override
    public void smoothMount$setRotation(float yaw, float pitch) {
        setRotation(yaw, pitch);
    }


}
