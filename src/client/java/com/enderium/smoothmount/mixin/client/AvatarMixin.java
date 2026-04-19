package com.enderium.smoothmount.mixin.client;

import com.enderium.smoothmount.client.animation.AnimationPack;
import com.enderium.smoothmount.client.model.animation.entity.PlayerAnimation.Dismount;
import com.enderium.smoothmount.client.model.animation.entity.PlayerAnimation.Mount;
import com.enderium.smoothmount.client.model.animation.entity.PlayerAnimationState;
import net.minecraft.world.entity.Avatar;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(Avatar.class)
public class AvatarMixin implements PlayerAnimationState {

    @Unique
    private MountType mountType;

    @Unique
    private AnimationPack mountAnimation;

    @Unique
    private DismountType dismountType;

    @Unique
    private AnimationPack dismountAnimation;

    @Inject(method = "<init>", at = @At("RETURN"))
    public void initFields(EntityType entityType, Level level, CallbackInfo ci) {
        mountType = MountType.DISABLE;
        mountAnimation = AnimationPack.of(Mount.MOUNT_BACK_M, Mount.MOUNT_RIGHT_M, Mount.MOUNT_LEFT_M, Mount.MOUNT_BACK_E, Mount.MOUNT_RIGHT_E, Mount.MOUNT_LEFT_E);

        dismountType = DismountType.DISABLE;
        dismountAnimation = AnimationPack.of(Dismount.DISMOUNT_BACK_M, Dismount.DISMOUNT_FORWARD_M, Dismount.DISMOUNT_BACK_E, Dismount.DISMOUNT_FORWARD_E);

    }


    @Override
    public AnimationPack mountAnimation() {
        return mountAnimation;
    }

    @Override
    public void mountAnimation(AnimationPack pack) {

    }

    @Override
    public MountType mountState() {
        return mountType;
    }

    @Override
    public void mountState(@NotNull MountType type) {
        this.mountType = type;
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

    }
}
