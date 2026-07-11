package com.enderium.smoothmount.mixin.client;

import com.enderium.smoothmount.client.animation.TransformChannel;
import com.enderium.smoothmount.client.animation.definition.EntityAnimation;
import com.enderium.smoothmount.client.model.animation.entity.AnimationType;
import com.enderium.smoothmount.client.model.animation.entity.PlayerAnimationState;
import com.enderium.smoothmount.state.MountState;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.entity.ClientAvatarEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.player.AvatarRenderer;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Avatar;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import org.joml.Vector3f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Arrays;
import java.util.Optional;

@Mixin(AvatarRenderer.class)
public class AvatarRendererMixin<AvatarlikeEntity extends Avatar & ClientAvatarEntity> {

    @Unique
    private Entry[] animations;


    @Inject(method = "<init>", at = @At("TAIL"))
    public void init(EntityRendererProvider.Context context, boolean bl, CallbackInfo ci) {

        animations = Arrays.stream(AnimationType.ANIMATIONS_E).map(e -> new Entry(e.bake(),AnimationType.INDEX_ANIMATION.getInt(e))).toArray(Entry[]::new);

    }


    @Inject(method = "extractRenderState(Lnet/minecraft/world/entity/Avatar;Lnet/minecraft/client/renderer/entity/state/AvatarRenderState;F)V",
            at = @At("TAIL"))
    public void setRidingTime(AvatarlikeEntity avatar, AvatarRenderState avatarRenderState, float f, CallbackInfo ci) {
        MountState state = (MountState) avatarRenderState;
        PlayerAnimationState pState = (PlayerAnimationState) avatarRenderState;
        MountState mountState = (MountState) avatar;
        PlayerAnimationState playerState = (PlayerAnimationState) avatar;
        state.setPlayerPos(mountState.getPlayerPos(f));
        state.setLastPosition(new Vec3(avatarRenderState.x, avatarRenderState.y, avatarRenderState.z));
        state.setLastVehicle(mountState.getLastVehicle().orElse(null));
        if (avatar.getVehicle() != null) {
            float rotation = avatar.getVehicle().getPreciseBodyRotation(f);
            state.setMountYaw(rotation);
        }

        float ageInTicks = avatarRenderState.ageInTicks;
        playerState.smoothMount$checkAndStop();
        pState.smoothMount$copyFrom(playerState);


        Vector3f rotateOffset = new Vector3f();

        if (playerState.animationPack().isStarted()&&playerState.getIndex()!=-1) {
            Entry entry = animations[playerState.getIndex()];
            EntityAnimation animation = entry.animation();
            if (pState.state() == PlayerAnimationState.AnimationState.MOUNT){
                pState.animationPack().update(entry.index(),animation,ageInTicks);
                TransformChannel channel = animation.offsetTransform();
                channel.position().currentValue.div(16, rotateOffset).rotateY(org.joml.Math.toRadians(state.getMountYaw()));
            }
            else {
                pState.animationPack().update(entry.index(),animation,ageInTicks, 1f);
                Optional<Entity> vehicle = mountState.getLastVehicle();
                if (vehicle.isPresent()) {
                    Entity entity = vehicle.get();


                    MountState eState = (MountState) entity;
                    Vec3 vec = entity.getPosition(f);
                    Vec3 pVec = eState.smoothMount$getPassengerAttachmentPoint(avatar, f);
                    Vec3 vVec = mountState.smoothMount$getVehicleAttachmentPoint(avatar);
                    double pX = avatarRenderState.x;
                    double pY = avatarRenderState.y;
                    double pZ = avatarRenderState.z;
                    TransformChannel channel = animation.offsetTransform();
                    channel.getPosition().div(16, rotateOffset);
                    avatarRenderState.x = vec.x + pVec.x - vVec.x;
                    avatarRenderState.y = vec.y + pVec.y - vVec.y;
                    avatarRenderState.z = vec.z + pVec.z - vVec.z;



                    state.setMountYaw((float) Math.toDegrees(Math.atan2(pZ - vec.z, pX - vec.x)) + 90f);


                    state.setMountYaw(state.getMountYaw() + channel.getRotation().y);


                    float x = (float) (pX - avatarRenderState.x);
                    float z = (float) (pZ - avatarRenderState.z);

                    float off = org.joml.Math.sqrt(x * x + z * z);
                    rotateOffset.z *= off;


                    TransformChannel motion = animation.get("mount_motion");
                    if (motion!=null){
                        float y = motion.getPosition().y;
                        avatarRenderState.y += (avatarRenderState.y - pY) * y + 0.01; // > 1?
                        rotateOffset.rotateY(org.joml.Math.toRadians(state.getMountYaw()));

                        float rOffset = Mth.wrapDegrees(avatarRenderState.bodyRot - state.getMountYaw());
                        state.setMountYaw(state.getMountYaw() + rOffset * -y);
                    }
                }

            }

        }

        avatarRenderState.x += rotateOffset.x;
        avatarRenderState.y += rotateOffset.y;
        avatarRenderState.z -= rotateOffset.z;

    }


    @ModifyVariable(method = "setupRotations(Lnet/minecraft/client/renderer/entity/state/AvatarRenderState;Lcom/mojang/blaze3d/vertex/PoseStack;FF)V", index = 3, at = @At(value = "HEAD"), argsOnly = true)
    public float addRot(float value, @Local(argsOnly = true) AvatarRenderState state) {
        PlayerAnimationState pState = (PlayerAnimationState) state;
        MountState mState = (MountState) state;
        if (!pState.smoothMount$IsStopped()) return mState.getMountYaw();
        /*if (state.isPassenger && !pState.smoothMount$IsStopped()) return mState.getMountYaw();
        if (pState.dismountState().isEnabled()) return mState.getMountYaw();*/
        return value;
    }

    public record Entry(EntityAnimation animation, int index){}

}
