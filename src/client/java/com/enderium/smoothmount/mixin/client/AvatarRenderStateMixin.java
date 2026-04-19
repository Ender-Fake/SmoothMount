package com.enderium.smoothmount.mixin.client;

import com.enderium.smoothmount.client.animation.AnimationPack;
import com.enderium.smoothmount.client.model.animation.entity.PlayerAnimationState;
import com.enderium.smoothmount.state.MountState;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
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
    private MountType mountType = MountType.DISABLE;

    @Unique
    private DismountType dismountType = DismountType.DISABLE;

    @Unique
    private AnimationPack mountAnimation;

    @Unique
    private AnimationPack dismountAnimation;


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
    public AnimationPack mountAnimation() {
        return mountAnimation;
    }

    @Override
    public void mountAnimation(AnimationPack pack) {
        mountAnimation = pack;
    }

    @Override
    public MountType mountState() {
        return mountType;
    }

    @Override
    public void mountState(@NotNull MountType type) {
        mountType = type;
    }


    @Override
    public DismountType dismountState() {
        return dismountType;
    }

    @Override
    public void dismountState(@NotNull DismountType type) {
        dismountType = type;
    }

    @Override
    public AnimationPack dismountAnimation() {
        return dismountAnimation;
    }

    @Override
    public void dismountAnimation(AnimationPack pack) {
        dismountAnimation = pack;
    }

}
