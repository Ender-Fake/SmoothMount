package com.enderium.smoothmount.client.model.animation.entity;

import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.world.entity.AnimationState;
import org.jetbrains.annotations.NotNull;

import static com.enderium.smoothmount.client.model.animation.entity.AnimationData.timeout;

public interface PlayerAnimationState extends AnimationData {

    AnimationState mountAnimation();

    MountType mountState();

    void mountState(@NotNull MountType type);

    default void startMount(@NotNull MountType type, int ticks) {
        mountState(type);
        mountAnimation().start(ticks);
    }


    AnimationState dismountAnimation();


    DismountType dismountState();

    void dismountState(@NotNull DismountType type);

    default void startDismount(@NotNull DismountType type, int ticks) {
        dismountState(type);
        dismountAnimation().start(ticks);
    }

    default void smoothMount$stopMount() {
        mountState(MountType.DISABLE);
    }

    default void smoothMount$stopDismount() {
        dismountState(DismountType.DISABLE);
    }

    default boolean smoothMount$IsStopped() {
        return !(mountState().isEnabled() || dismountState().isEnabled());
    }

    default void smoothMount$checkAndStop(float time) {
        if (mountState().isEnabled() && timeout(time, mountAnimation(), mountState().animation))
            mountState(MountType.DISABLE);
        if (dismountState().isEnabled() && timeout(time, dismountAnimation(), dismountState().animation))
            dismountState(DismountType.DISABLE);

    }

    default void smoothMount$copyFrom(PlayerAnimationState state) {
        mountAnimation().copyFrom(state.mountAnimation());
        mountState(state.mountState());

        dismountAnimation().copyFrom(state.dismountAnimation());
        dismountState(state.dismountState());

    }


    enum MountType {
        DISABLE(null),
        BACK(PlayerAnimation.MOUNT_BACK),
        LEFT(PlayerAnimation.MOUNT_LEFT),
        RIGHT(PlayerAnimation.MOUNT_RIGHT);

        public final AnimationDefinition animation;

        MountType(AnimationDefinition definition) {
            this.animation = definition;
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
        BACK(PlayerAnimation.DISMOUNT_BACK, 0, -1, 0.1667F, 0.4167F),
        FORWARD(PlayerAnimation.DISMOUNT_FORWARD, 180, 1, 0.1667F, 0.4167F);
        //LEFT(PlayerAnimation.MOUNT_LEFT),
        //RIGHT(PlayerAnimation.MOUNT_RIGHT);

        public final AnimationDefinition animation;
        public final float yawOffset;
        public final float zOffset;
        public final float timeStartMoveY;
        public final float timeEndMoveY;
        public final float timeScaleMoveY;

        DismountType() {
            animation = null;
            yawOffset = 0;
            zOffset = 0;
            timeStartMoveY = 0;
            timeEndMoveY = 1;
            timeScaleMoveY = 1;
        }

        DismountType(AnimationDefinition definition, float yawOffset, float zOffset, float timeStartMoveY, float timeEndMoveY) {
            this.animation = definition;
            this.yawOffset = yawOffset;
            this.zOffset = zOffset;
            this.timeStartMoveY = timeStartMoveY;
            this.timeEndMoveY = timeEndMoveY;
            float range = timeEndMoveY - timeStartMoveY;
            this.timeScaleMoveY = range == 0 ? 0 : 1 / range;
        }

        public boolean isDisable() {
            return this == DISABLE;
        }

        public boolean isEnabled() {
            return this != DISABLE;
        }

    }


}
