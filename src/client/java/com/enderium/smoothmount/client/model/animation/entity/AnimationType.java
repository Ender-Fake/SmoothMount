package com.enderium.smoothmount.client.model.animation.entity;

import com.enderium.smoothmount.client.animation.IndexProvider;
import com.enderium.smoothmount.client.animation.definition.EntityAnimationDefinition;
import com.enderium.smoothmount.client.animation.definition.ModelAnimationDefinition;
import com.enderium.smoothmount.client.entity.EntityContext;
import com.enderium.smoothmount.client.model.animation.entity.PlayerAnimation.Dismount;
import com.enderium.smoothmount.client.model.animation.entity.PlayerAnimation.Minecart;
import com.enderium.smoothmount.client.model.animation.entity.PlayerAnimation.Mount;
import it.unimi.dsi.fastutil.objects.Object2IntLinkedOpenHashMap;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;

public interface AnimationType {

    void mount(PlayerAnimationState state, EntityContext self, EntityContext vehicle);

    void dismount(PlayerAnimationState state, EntityContext self, EntityContext vehicle, Vec3 mountTo);


    AnimationType DefaultAnimation = new AnimationType() {

        private final AnimationContext context = AnimationContext.of(1.3f);

        @Override
        public void mount(PlayerAnimationState state, EntityContext self, EntityContext vehicle) {
            state.setContext(AnimationContext.DEFAULT);
            float yR = Mth.wrapDegrees(self.yRot() - vehicle.yRot());
            if (Math.abs(yR) < 35) AnimationType.start(state, Mount.MOUNT_BACK_M, Mount.MOUNT_BACK_E);
            else if (yR < 0) AnimationType.start(state, Mount.MOUNT_RIGHT_M, Mount.MOUNT_RIGHT_E);
            else AnimationType.start(state, Mount.MOUNT_LEFT_M, Mount.MOUNT_LEFT_E);
            state.animationPack().state().start(self.tickCount());
        }

        @Override
        public void dismount(PlayerAnimationState state, EntityContext self, EntityContext vehicle, Vec3 mountTo) {
            state.setContext(context);
            Vec3 pos = self.getPos();
            float angleTo = (float) Math.toDegrees(Math.atan2(pos.z - mountTo.z, pos.x - mountTo.x)) + 90f;
            float angleCross = Mth.wrapDegrees(self.yBodyRot() - angleTo);
            if (Math.abs(angleCross) < 89)
                AnimationType.start(state, Dismount.DISMOUNT_FORWARD_M, Dismount.DISMOUNT_FORWARD_E);
            else AnimationType.start(state, Dismount.DISMOUNT_BACK_M, Dismount.DISMOUNT_BACK_E);
            state.animationPack().state().start(self.tickCount());
        }
    };

    AnimationType MinecartAnimation = new AnimationType() {
        @Override
        public void mount(PlayerAnimationState state, EntityContext self, EntityContext vehicle) {
            state.setContext(AnimationContext.DEFAULT);

        }

        @Override
        public void dismount(PlayerAnimationState state, EntityContext self, EntityContext vehicle, Vec3 mountTo) {
            state.setContext(AnimationContext.DEFAULT);
            AnimationType.start(state, Minecart.MINECART_MOUNT_M, Minecart.MINECART_MOUNT_E);
            state.animationPack().state().start(self.tickCount());
        }
    };


    IndexProvider[] ANIMATIONS = new IndexProvider[]{
            Mount.MOUNT_BACK_M, Mount.MOUNT_RIGHT_M, Mount.MOUNT_LEFT_M,
            Dismount.DISMOUNT_BACK_M, Dismount.DISMOUNT_FORWARD_M, Minecart.MINECART_MOUNT_M,
            Mount.MOUNT_BACK_E, Mount.MOUNT_RIGHT_E, Mount.MOUNT_LEFT_E,
            Dismount.DISMOUNT_BACK_E, Dismount.DISMOUNT_FORWARD_E, Minecart.MINECART_MOUNT_E
    };

    ModelAnimationDefinition[] ANIMATIONS_M = new ModelAnimationDefinition[]{Mount.MOUNT_BACK_M, Mount.MOUNT_RIGHT_M, Mount.MOUNT_LEFT_M, Dismount.DISMOUNT_BACK_M, Dismount.DISMOUNT_FORWARD_M, Minecart.MINECART_MOUNT_M};
    EntityAnimationDefinition[] ANIMATIONS_E = new EntityAnimationDefinition[]{Mount.MOUNT_BACK_E, Mount.MOUNT_RIGHT_E, Mount.MOUNT_LEFT_E, Dismount.DISMOUNT_BACK_E, Dismount.DISMOUNT_FORWARD_E, Minecart.MINECART_MOUNT_E};

    Object2IntLinkedOpenHashMap<IndexProvider> INDEX_M = groupAnimation(ANIMATIONS_M);
    Object2IntLinkedOpenHashMap<IndexProvider> INDEX_E = groupAnimation(ANIMATIONS_E);
    Object2IntLinkedOpenHashMap<IndexProvider> INDEX_ANIMATION = groupAnimation(ANIMATIONS);

    private static void start(PlayerAnimationState state, IndexProvider model, IndexProvider entity) {
        int m = INDEX_M.getInt(model);
        start(state, m, m, INDEX_ANIMATION.getInt(entity));
    }

    private static void start(PlayerAnimationState state, int type, int model, int entity) {
        state.setIndex(type);
        if (model != -1) state.animationPack().clear(model);
        if (entity != -1) state.animationPack().clear(entity);
    }

    private static Object2IntLinkedOpenHashMap<IndexProvider> groupAnimation(IndexProvider... channels) {
        Object2IntLinkedOpenHashMap<IndexProvider> map = new Object2IntLinkedOpenHashMap<>(channels.length);
        map.defaultReturnValue(-1);
        for (int i = 0; i < channels.length; i++) map.put(channels[i], i);
        return map;
    }

}
