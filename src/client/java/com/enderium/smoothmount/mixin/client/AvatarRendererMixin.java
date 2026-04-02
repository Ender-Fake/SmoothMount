package com.enderium.smoothmount.mixin.client;

import com.enderium.smoothmount.client.model.animation.entity.PlayerAnimationState;
import com.enderium.smoothmount.client.model.animation.entity.PlayerAnimationState.DismountType;
import com.enderium.smoothmount.state.MountState;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.entity.ClientAvatarEntity;
import net.minecraft.client.renderer.entity.player.AvatarRenderer;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import net.minecraft.world.entity.Avatar;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AvatarRenderer.class)
public class AvatarRendererMixin<AvatarlikeEntity extends Avatar & ClientAvatarEntity> {


    @Inject(method = "extractRenderState(Lnet/minecraft/world/entity/Avatar;Lnet/minecraft/client/renderer/entity/state/AvatarRenderState;F)V",
            at = @At("TAIL"))
    public void setRidingTime(AvatarlikeEntity avatar, AvatarRenderState avatarRenderState, float f, CallbackInfo ci) {
        MountState state = (MountState) avatarRenderState;
        PlayerAnimationState pState = (PlayerAnimationState) avatarRenderState;
        MountState mountState = (MountState) avatar;
        PlayerAnimationState playerState = (PlayerAnimationState) avatar;
        state.setPlayerPos(mountState.getPlayerPos(f));
        //state.setLastPosition(mountState.getLastPosition());
        state.setLastPosition(new Vec3(avatarRenderState.x,avatarRenderState.y,avatarRenderState.z));
        state.setLastVehicle(mountState.getLastVehicle().orElse(null));
        float offsetY;
        if (avatar.getVehicle() != null) {
            float rotation = avatar.getVehicle().getPreciseBodyRotation(f);
            state.setMountYaw(rotation);
            offsetY=rotation - avatarRenderState.yRot;
        }
        //else offsetY=0;

        float ageInTicks = avatarRenderState.ageInTicks;
        playerState.smoothMount$checkAndStop(ageInTicks);
        pState.smoothMount$copyFrom(playerState);

        //pState.mountBackAnimation().startIfStopped(avatar.tickCount);

        DismountType dismountType = pState.dismountState();
        if (dismountType.isEnabled()) {
            mountState.getLastVehicle().ifPresent(entity -> {
                MountState eState = (MountState) entity;
                Vec3 vec = entity.getPosition(f);
                Vec3 pVec = eState.smoothMount$getPassengerAttachmentPoint(avatar, f);
                Vec3 vVec = mountState.smoothMount$getVehicleAttachmentPoint(avatar);
                /*double pX = avatarRenderState.x;
                double pY = avatarRenderState.y;
                double pZ = avatarRenderState.z;
                */

                state.setMountYaw((float) Math.toDegrees(Math.atan2(avatarRenderState.z - vec.z, avatarRenderState.x - vec.x))+90f+dismountType.yawOffset);

                avatarRenderState.x = vec.x + pVec.x - vVec.x;
                avatarRenderState.y = vec.y + pVec.y - vVec.y;
                avatarRenderState.z = vec.z + pVec.z - vVec.z;
                /*assert dismountType.animation != null;
                float len = dismountType.animation.lengthInSeconds();
                float time = pState.dismountAnimation().getTimeInMillis(ageInTicks) / 1000f;
                float delta = Math.min(time / len, 1f);

                if (delta> dismountType.timeAfterMoveXZ){
                    float finalDelta = (delta - dismountType.timeAfterMoveXZ) * (1f/(1-dismountType.timeAfterMoveXZ));
                    avatarRenderState.x = Mth.lerp(finalDelta, avatarRenderState.x, pX);
                    avatarRenderState.z = Mth.lerp(finalDelta, avatarRenderState.z, pZ);


                }*/

                /*if (delta > 0.6) {
                    float finalDelta = (delta - 0.6f) * 2.5f;
                    //float y = (float) vVec.y-1;
                    avatarRenderState.x = Mth.lerp(finalDelta, avatarRenderState.x, pX);
                    avatarRenderState.y = Mth.lerp(finalDelta, avatarRenderState.y, pY);
                    avatarRenderState.z = Mth.lerp(finalDelta, avatarRenderState.z, pZ);

                }*/

            });
        }

        /*float len = PlayerAnimationState.DismountType.BACK.animation.lengthInSeconds();
        float time = pState.dismountAnimation().getTimeInMillis(ageInTicks) / 1000f;
        float delta = time / len;
        if (delta>0.5){
            float finalDelta = Math.min((delta - 0.5f) * 2, 1f);
            state.getLastVehicle().ifPresent(entity -> {
                MountState mEntity = (MountState) entity;
                float y = (float) mEntity.smoothMount$getPassengerAttachmentPoint(entity, 1).y;
                //root.y+=  (y * finalDelta);//*16;
            });
        }*/

    }


    @ModifyVariable(method = "setupRotations(Lnet/minecraft/client/renderer/entity/state/AvatarRenderState;Lcom/mojang/blaze3d/vertex/PoseStack;FF)V", index = 3, at = @At(value = "HEAD"), argsOnly = true)
    public float addRot(float value, @Local(argsOnly = true) AvatarRenderState state) {
        PlayerAnimationState pState = (PlayerAnimationState) state;
        MountState mState = (MountState) state;
        if (state.isPassenger && !pState.smoothMount$IsStopped()) return mState.getMountYaw();
        if (pState.dismountState().isEnabled()) return mState.getMountYaw();
        return value;
    }
    /*    public float addRot(float value, @Local(argsOnly = true) AvatarRenderState state) {
        PlayerAnimationState pState = (PlayerAnimationState) state;
        MountState mState = (MountState) state;
        if (state.isPassenger && !pState.smoothMount$IsStopped()) return mState.getMountYaw();
        DismountType type = pState.dismountState();
        if (type.isEnabled()){
            assert type.animation != null;
            float len = type.animation.lengthInSeconds();
            float time = pState.dismountAnimation().getTimeInMillis(state.ageInTicks) / 1000f;
            float delta = Math.min(time / len, 1f);
            float mY = Mth.wrapDegrees(mState.getMountYaw()) + 360;
            float rY = Mth.wrapDegrees(value) + 360;
            float tY = Mth.wrapDegrees(rY-mY);
            //System.out.println(mY +" | "+ rY+" | "+tY);



            if (delta > 0.43) return mY+tY* org.joml.Math.sin(((delta - 0.43f) * 1.754386f)* 3.141592653589793f/2);
            return mState.getMountYaw();
        }
        return value;
    }*/



}
