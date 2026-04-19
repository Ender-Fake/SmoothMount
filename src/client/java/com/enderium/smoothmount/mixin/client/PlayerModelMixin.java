package com.enderium.smoothmount.mixin.client;


import com.enderium.smoothmount.client.animation.definition.ModelAnimation;
import com.enderium.smoothmount.client.model.ModelPartChildren;
import com.enderium.smoothmount.client.model.animation.entity.PlayerAnimation;
import com.enderium.smoothmount.client.model.animation.entity.PlayerAnimationState;
import com.enderium.smoothmount.compat.OtherRenderPart;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.player.PlayerModel;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import org.joml.Vector3f;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Debug(export = true)
@Mixin(value = PlayerModel.class, priority = 5000)
public class PlayerModelMixin extends HumanoidModel<AvatarRenderState> {

    @Unique
    private ModelAnimation mountBackAnimation;
    @Unique
    private ModelAnimation mountRightAnimation;
    @Unique
    private ModelAnimation mountLeftAnimation;

    @Unique
    private ModelAnimation dismountBackAnimation;
    @Unique
    private ModelAnimation dismountForwardAnimation;

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

        mountBackAnimation = PlayerAnimation.Mount.MOUNT_BACK_M.bake(modelPart);
        mountRightAnimation = PlayerAnimation.Mount.MOUNT_RIGHT_M.bake(modelPart);
        mountLeftAnimation = PlayerAnimation.Mount.MOUNT_LEFT_M.bake(modelPart);
        dismountBackAnimation = PlayerAnimation.Dismount.DISMOUNT_BACK_M.bake(modelPart);
        dismountForwardAnimation = PlayerAnimation.Dismount.DISMOUNT_FORWARD_M.bake(modelPart);

    }


    @Inject(method = "setupAnim(Lnet/minecraft/client/renderer/entity/state/AvatarRenderState;)V",
            at = @At(value = "TAIL")
    )
    public void setAnim(AvatarRenderState avatarRenderState, CallbackInfo ci) {

        //MountState mState = (MountState) avatarRenderState;
        PlayerAnimationState pState = (PlayerAnimationState) avatarRenderState;


        boolean b = pState.smoothMount$IsStopped();
        if (root instanceof OtherRenderPart part) part.enableVanilla(!b);
        if (b) return;


        if (pState.dismountAnimation().isStarted()) {
            ((ModelPartChildren) leftLeg).resetPoseAndChildren();
            ((ModelPartChildren) rightLeg).resetPoseAndChildren();
            ((ModelPartChildren) leftArm).resetPoseOnlyChildren();
            ((ModelPartChildren) rightArm).resetPoseOnlyChildren();

        } else for (ModelPart part : bodyPartsResetMount) ((ModelPartChildren) part).resetPoseAndChildren();
/*        List<ModelPart> bParts=pState.dismountState().isEnabled() ? bodyPartsResetDismount : bodyPartsResetMount;
        for (ModelPart part : bParts) ((ModelPartChildren) part).resetPoseAndChildren();*/

        float ageInTicks = avatarRenderState.ageInTicks;

        if (pState.mountState().isEnabled()) {

            switch (pState.mountState()) {
                case BACK -> pState.mountAnimation().update(0, mountBackAnimation, ageInTicks);
                case LEFT -> pState.mountAnimation().update(2, mountLeftAnimation, ageInTicks);
                case RIGHT -> pState.mountAnimation().update(1, mountRightAnimation, ageInTicks);
                default -> throw new IllegalStateException("Unexpected value: " + pState.mountState());
            }
        }

        if (pState.dismountState().isEnabled()) {
            PlayerAnimationState.DismountType dismountType = pState.dismountState();

            switch (dismountType) {
                case BACK -> pState.dismountAnimation().update(0, dismountBackAnimation, ageInTicks, 1.2f);
                case FORWARD -> pState.dismountAnimation().update(1, dismountForwardAnimation, ageInTicks, 1.2f);
                default -> throw new IllegalStateException("Unexpected value: " + dismountType);
            }
        }

        Vector3f offset = new Vector3f(body.x, body.y, body.z);
        Vector3f offsetRot = new Vector3f(body.xRot, body.yRot, body.zRot);

        for (ModelPart part : bodyParts) {
            part.offsetPos(offset);
            part.offsetRotation(offsetRot);
        }
        //57.29577951308232


    }

}
