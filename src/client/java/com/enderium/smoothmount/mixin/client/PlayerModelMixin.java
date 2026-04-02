package com.enderium.smoothmount.mixin.client;


import com.enderium.smoothmount.client.model.ModelPartChildren;
import com.enderium.smoothmount.client.model.animation.entity.PlayerAnimation;
import com.enderium.smoothmount.client.model.animation.entity.PlayerAnimationState;
import com.enderium.smoothmount.compat.OtherRenderPart;
import com.enderium.smoothmount.state.MountState;
import net.minecraft.client.animation.KeyframeAnimation;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.player.PlayerModel;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import org.joml.Math;
import org.joml.Vector3f;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.Optional;

@Debug(export = true)
@Mixin(value = PlayerModel.class, priority = 5000)
public class PlayerModelMixin extends HumanoidModel<AvatarRenderState> {

    @Unique
    private KeyframeAnimation mountBackAnimation;
    @Unique
    private KeyframeAnimation mountRightAnimation;
    @Unique
    private KeyframeAnimation mountLeftAnimation;

    @Unique
    private KeyframeAnimation dismountBackAnimation;
    @Unique
    private KeyframeAnimation dismountForwardAnimation;

    @Unique
    private final List<ModelPart> bodyParts = List.of(leftLeg, rightLeg, leftArm, rightArm, head);
    @Unique
    private final List<ModelPart> bodyPartsResetMount = List.of(leftLeg, rightLeg, leftArm, rightArm);
    @Unique
    private final List<ModelPart> bodyPartsResetDismount = List.of(leftLeg, rightLeg);


    //@Unique
    public PlayerModelMixin(ModelPart modelPart) {
        super(modelPart);
    }

    @Inject(method = "<init>", at = @At("TAIL"))
    public void init(ModelPart modelPart, boolean bl, CallbackInfo ci) {

        mountBackAnimation = PlayerAnimation.MOUNT_BACK.bake(modelPart);
        mountRightAnimation = PlayerAnimation.MOUNT_RIGHT.bake(modelPart);
        mountLeftAnimation = PlayerAnimation.MOUNT_LEFT.bake(modelPart);
        dismountBackAnimation = PlayerAnimation.DISMOUNT_BACK.bake(modelPart);
        dismountForwardAnimation = PlayerAnimation.DISMOUNT_FORWARD.bake(modelPart);

    }


    @Inject(method = "setupAnim(Lnet/minecraft/client/renderer/entity/state/AvatarRenderState;)V",
            at = @At(value = "TAIL")
    )
    public void setAnim(AvatarRenderState avatarRenderState, CallbackInfo ci) {

        MountState mState = (MountState) avatarRenderState;
        PlayerAnimationState pState = (PlayerAnimationState) avatarRenderState;


        boolean b = pState.smoothMount$IsStopped();
        if (root instanceof OtherRenderPart part) part.enableVanilla(!b);
        if (b) return;


        if (pState.dismountState().isEnabled()){
            ((ModelPartChildren) leftLeg).resetPoseAndChildren();
            ((ModelPartChildren) rightLeg).resetPoseAndChildren();
            ((ModelPartChildren) leftArm).resetPoseOnlyChildren();
            ((ModelPartChildren) rightArm).resetPoseOnlyChildren();

        }
        else {
            for (ModelPart part : bodyPartsResetMount) ((ModelPartChildren) part).resetPoseAndChildren();
        }
/*        List<ModelPart> bParts=pState.dismountState().isEnabled() ? bodyPartsResetDismount : bodyPartsResetMount;
        for (ModelPart part : bParts) ((ModelPartChildren) part).resetPoseAndChildren();*/

        float ageInTicks = avatarRenderState.ageInTicks;

        if (pState.mountState().isEnabled()) {
            KeyframeAnimation animation = switch (pState.mountState()) {
                case BACK -> mountBackAnimation;
                case LEFT -> mountLeftAnimation;
                case RIGHT -> mountRightAnimation;
                default -> throw new IllegalStateException("Unexpected value: " + pState.mountState());
            };
            animation.apply(pState.mountAnimation(), ageInTicks);
        }

        if (pState.dismountState().isEnabled()) {
            PlayerAnimationState.DismountType dismountType = pState.dismountState();
            KeyframeAnimation animation = switch (dismountType) {
                case BACK -> dismountBackAnimation;
                case FORWARD -> dismountForwardAnimation;
                default -> throw new IllegalStateException("Unexpected value: " + dismountType);
            };
            animation.apply(pState.dismountAnimation(), ageInTicks);

            Optional<Entity> vehicle = mState.getLastVehicle();
            if (vehicle.isEmpty()) return;
            float len = dismountType.animation.lengthInSeconds();
            float time = pState.dismountAnimation().getTimeInMillis(ageInTicks) / 1000f;
            float delta = time / len;


            // Vec3 vPos =  vehicle.get().position().add(mState.smoothMount$getPassengerAttachmentPoint(vehicle.get(),0));//vehicle.get().position();
            Vec3 vPos = new Vec3(avatarRenderState.x, avatarRenderState.y, avatarRenderState.z);
            Vec3 pPos = mState.getPlayerPos(1);

            float x = (float) (pPos.x - vPos.x);
            float y = (float) (pPos.y - vPos.y);
            float z = (float) (pPos.z - vPos.z);

            float off = org.joml.Math.sqrt(x * x + z * z);

            //System.out.println(off+ " "+delta+" | "+vPos+" "+pPos+" | "+new Vec3(avatarRenderState.x,avatarRenderState.y,avatarRenderState.z));
            //root.z+= delta * off * 16 * -dismountType.zOffset;
            root.z *= off;


            if (delta > dismountType.timeEndMoveY){
                root.y -= y * 16;
                //root.yRot+=Math.toRadians(avatarRenderState.bodyRot - mState.getMountYaw());
            }
            else if (delta > dismountType.timeStartMoveY) {
                float v = (delta - dismountType.timeStartMoveY) * dismountType.timeScaleMoveY;
                root.y -= y * v * 16;
                //System.out.println(delta + " | " + v);
/*                float rOffset =avatarRenderState.bodyRot - mState.getMountYaw();
                root.yRot+=Math.toRadians(rOffset *v);*/
            }


            float rOffset = Mth.wrapDegrees(avatarRenderState.bodyRot - mState.getMountYaw());
            root.yRot+=Math.toRadians(rOffset *delta);




        }


        Vector3f offset = new Vector3f(body.x, body.y, body.z);
        Vector3f offsetRot = new Vector3f(body.xRot, body.yRot, body.zRot);

        for (ModelPart part : bodyParts) {
            part.offsetPos(offset);
            part.offsetRotation(offsetRot);
        }
        //57.29577951308232


        /*float yaw = ((MountState) avatarRenderState).getMountYaw();
        avatarRenderState.bodyRot=yaw;*/


    }

}
