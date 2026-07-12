package com.enderium.smoothmount.client.model.animation.entity;

import com.enderium.smoothmount.client.animation.AnimationPack;

public interface PlayerAnimationState {

    AnimationType animationType();

    void animationType(AnimationType type);

    AnimationPack animationPack();

    void animationPack(AnimationPack pack);

    void setIndex(int state);

    int getIndex();

    AnimationState state();

    void state(AnimationState state);

    AnimationContext getContext();

    void setContext(AnimationContext context);

    default void smoothMount$stopMount() {
        animationPack().state().stop();
    }

    default void smoothMount$stopDismount() {
        animationPack().state().stop();
    }

    default boolean smoothMount$IsStopped() {
        return animationPack().isStopped();
    }

    default void smoothMount$checkAndStop() {
        if (animationPack().isStopped()) setIndex(-1);
    }

    default void smoothMount$copyFrom(PlayerAnimationState state) {
        animationPack(state.animationPack());
        animationType(state.animationType());
        setIndex(state.getIndex());
        state(state.state());
        setContext(state.getContext());
    }


    enum AnimationState {
        MOUNT,
        DISMOUNT
    }


}
