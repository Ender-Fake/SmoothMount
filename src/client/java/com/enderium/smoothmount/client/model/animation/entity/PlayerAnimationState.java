package com.enderium.smoothmount.client.model.animation.entity;

import com.enderium.smoothmount.client.animation.AnimationPack;
import com.enderium.smoothmount.client.animation.definition.EntityAnimationDefinition;
import com.enderium.smoothmount.client.animation.definition.ModelAnimationDefinition;
import com.enderium.smoothmount.client.model.animation.entity.PlayerAnimation.Mount;
import org.jetbrains.annotations.NotNull;

public interface PlayerAnimationState extends AnimationData {

    AnimationPack mountAnimation();

    void mountAnimation(AnimationPack pack);


    MountType mountState();

    void mountState(@NotNull MountType type);

    default void startMount(@NotNull MountType type, int ticks) {
        mountState(type);
        mountAnimation().state().start(ticks);
    }

    DismountType dismountState();

    void dismountState(@NotNull DismountType type);

    default void startDismount(@NotNull DismountType type, int ticks) {
        dismountState(type);
        dismountAnimation().state().start(ticks);
    }

    AnimationPack dismountAnimation();

    void dismountAnimation(AnimationPack pack);


    default void smoothMount$stopMount() {
        mountState(MountType.DISABLE);
        mountAnimation().state().stop();
    }

    default void smoothMount$stopDismount() {
        dismountState(DismountType.DISABLE);
        dismountAnimation().state().stop();
    }

    default boolean smoothMount$IsStopped() {
        return !(mountAnimation().isStarted() || dismountAnimation().isStarted());
    }

    default void smoothMount$checkAndStop(float time) {
        if (mountAnimation().isStopped()) mountState(MountType.DISABLE);
        if (dismountAnimation().isStopped()) dismountState(DismountType.DISABLE);

    }

    default void smoothMount$copyFrom(PlayerAnimationState state) {
        mountState(state.mountState());
        mountAnimation(state.mountAnimation());

        dismountState(state.dismountState());
        dismountAnimation(state.dismountAnimation());

    }


    enum MountType {
        DISABLE(null, null),
        BACK(Mount.MOUNT_BACK_M, Mount.MOUNT_BACK_E),
        LEFT(Mount.MOUNT_LEFT_M, Mount.MOUNT_LEFT_E),
        RIGHT(Mount.MOUNT_RIGHT_M, Mount.MOUNT_RIGHT_E);

        public final ModelAnimationDefinition animationModel;
        public final EntityAnimationDefinition animationEntity;

        MountType(ModelAnimationDefinition animationModel, EntityAnimationDefinition animationEntity) {
            this.animationModel = animationModel;
            this.animationEntity = animationEntity;
        }

        public boolean isDisable() {
            return this == DISABLE;
        }

        public boolean isEnabled() {
            return this != DISABLE;
        }

    }

    enum DismountType {
        DISABLE,
        BACK(PlayerAnimation.Dismount.DISMOUNT_BACK_M, PlayerAnimation.Dismount.DISMOUNT_BACK_E, 0),
        FORWARD(PlayerAnimation.Dismount.DISMOUNT_FORWARD_M, PlayerAnimation.Dismount.DISMOUNT_FORWARD_E, 180);
        //LEFT(PlayerAnimation.MOUNT_LEFT),
        //RIGHT(PlayerAnimation.MOUNT_RIGHT);

        public final ModelAnimationDefinition animationModel;
        public final EntityAnimationDefinition animationEntity;
        public final float yawOffset;

        DismountType() {
            animationModel = null;
            animationEntity = null;
            yawOffset = 0;
        }

        DismountType(ModelAnimationDefinition definitionM, EntityAnimationDefinition definitionE, float yawOffset) {
            this.animationModel = definitionM;
            this.animationEntity = definitionE;
            this.yawOffset = yawOffset;
        }

        public boolean isDisable() {
            return this == DISABLE;
        }

        public boolean isEnabled() {
            return this != DISABLE;
        }

    }


}
