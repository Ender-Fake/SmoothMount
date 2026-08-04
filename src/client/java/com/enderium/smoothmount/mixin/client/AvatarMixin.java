package com.enderium.smoothmount.mixin.client;

import com.enderium.smoothmount.client.animation.AnimationPack;
import com.enderium.smoothmount.client.model.animation.entity.AnimationContext;
import com.enderium.smoothmount.client.model.animation.entity.AnimationType;
import com.enderium.smoothmount.client.model.animation.entity.PlayerAnimationState;
import net.minecraft.world.entity.Avatar;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;


@Mixin(Avatar.class)
public class AvatarMixin implements PlayerAnimationState {

    @Unique
    private AnimationPack animationPack = AnimationPack.of(AnimationType.ANIMATIONS);

    @Unique
    private AnimationType animationType = AnimationType.DefaultAnimation;

    @Unique
    private AnimationState animationState;

    @Unique
    private int animationIndex = -1;
    @Unique
    private AnimationContext context = AnimationContext.DEFAULT;


    @Override
    public boolean smoothMount$isInit() {
        return true;
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
        animationState = state;
    }

    @Override
    public AnimationContext getContext() {
        return context;
    }

    @Override
    public void setContext(AnimationContext context) {
        this.context = context;
    }

    @Override
    public AnimationPack animationPack() {
        return animationPack;
    }

    @Override
    public void animationPack(AnimationPack pack) {

    }


}
