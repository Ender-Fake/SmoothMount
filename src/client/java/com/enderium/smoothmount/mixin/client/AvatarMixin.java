package com.enderium.smoothmount.mixin.client;

import com.enderium.smoothmount.client.model.animation.entity.PlayerAnimationState;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Avatar;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(Avatar.class)
public class AvatarMixin implements PlayerAnimationState {

    @Unique
    private MountType mountType = MountType.DISABLE;

    @Unique
    private AnimationState mountAnimation = new AnimationState();

    @Unique
    private DismountType dismountType = DismountType.DISABLE;

    @Unique
    private AnimationState dismountAnimation = new AnimationState();

    @Override
    public MountType mountState() {
        return mountType;
    }

    @Override
    public void mountState(@NotNull MountType type) {
        this.mountType = type;
    }

    @Override
    public AnimationState mountAnimation() {
        return mountAnimation;
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
    public AnimationState dismountAnimation() {
        return dismountAnimation;
    }
}
