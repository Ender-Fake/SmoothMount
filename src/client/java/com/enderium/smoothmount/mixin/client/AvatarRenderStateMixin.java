package com.enderium.smoothmount.mixin.client;

import com.enderium.smoothmount.client.animation.AnimationPack;
import com.enderium.smoothmount.client.model.animation.entity.AnimationType;
import com.enderium.smoothmount.client.model.animation.entity.PlayerAnimationState;
import com.enderium.smoothmount.state.MountState;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

import java.lang.ref.WeakReference;
import java.util.Optional;

@Mixin(AvatarRenderState.class)
public class AvatarRenderStateMixin implements MountState, PlayerAnimationState {

    @Unique
    private Vec3 playerPos = Vec3.ZERO;
    @Unique
    private Vec3 lastMountPos = Vec3.ZERO;
    @Unique
    private float mountYaw;

    @Unique
    private AnimationPack animationPack;

    @Unique
    private AnimationType animationType;

    @Unique
    private AnimationState animationState;

    @Unique
    private int animationIndex;

    @Unique
    private WeakReference<Entity> lastMount = new WeakReference<>(null);

    @Override
    public Vec3 getPlayerPos(float delta) {
        return playerPos;
    }

    @Override
    public void setPlayerPos(Vec3 vec) {
        playerPos = vec;
    }

    @Override
    public Vec3 getLastPosition() {
        return lastMountPos;
    }

    @Override
    public void setLastPosition(Vec3 vec) {
        lastMountPos = vec;
    }

    @Override
    public float getMountYaw() {
        return mountYaw;
    }

    @Override
    public void setMountYaw(float yaw) {
        mountYaw = yaw;
    }

    @Override
    public Optional<Entity> getLastVehicle() {
        return Optional.ofNullable(lastMount.get());
    }

    @Override
    public void setLastVehicle(Entity vehicle) {
        lastMount = new WeakReference<>(vehicle);
    }

    @Override
    public Vec3 smoothMount$getPassengerAttachmentPoint(Entity entity, float d) {
        Optional<Entity> vehicle = getLastVehicle();
        return vehicle.isPresent() ? ((MountState) vehicle.get()).smoothMount$getPassengerAttachmentPoint(entity, d) : Vec3.ZERO;
    }

    @Override
    public Vec3 smoothMount$getVehicleAttachmentPoint(Entity entity) {
        Optional<Entity> vehicle = getLastVehicle();
        return vehicle.isPresent() ? ((MountState) vehicle.get()).smoothMount$getVehicleAttachmentPoint(entity) : Vec3.ZERO;
    }

    @Override
    public AnimationType animationType() {
        return animationType;
    }

    @Override
    public void animationType(AnimationType type) {
        animationType = type;
    }

    @Override
    public void setIndex(int state) {
        animationIndex = state;
    }

    @Override
    public int getIndex() {
        return animationIndex;
    }

    @Override
    public AnimationState state() {
        return animationState;
    }

    @Override
    public void state(AnimationState state) {
        animationState=state;
    }

    @Override
    public AnimationPack animationPack() {
        return animationPack;
    }

    @Override
    public void animationPack(AnimationPack pack) {
        animationPack = pack;
    }


}
