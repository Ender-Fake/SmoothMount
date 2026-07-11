package com.enderium.smoothmount.mixin.client;


import com.enderium.smoothmount.client.animation.AnimationPack;
import com.enderium.smoothmount.client.animation.definition.ModelAnimation;
import com.enderium.smoothmount.client.model.ModelPartChildren;
import com.enderium.smoothmount.client.model.animation.entity.AnimationType;
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

import java.util.Arrays;
import java.util.List;

@Debug(export = true)
@Mixin(value = PlayerModel.class, priority = 5000)
public class PlayerModelMixin extends HumanoidModel<AvatarRenderState> {

    @Unique
    private Entry[] animations;

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

        animations = Arrays.stream(AnimationType.ANIMATIONS_M).map(e -> new Entry(e.bake(modelPart), AnimationType.INDEX_ANIMATION.getInt(e))).toArray(Entry[]::new);

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

        AnimationPack pack = pState.animationPack();

        if (pack.isStarted()) {
/*            ((ModelPartChildren) leftLeg).resetPoseAndChildren();
            ((ModelPartChildren) rightLeg).resetPoseAndChildren();
            ((ModelPartChildren) leftArm).resetPoseOnlyChildren();
            ((ModelPartChildren) rightArm).resetPoseOnlyChildren();*/

            for (ModelPart part : bodyPartsResetMount) ((ModelPartChildren) part).resetPoseAndChildren();

        }

        float ageInTicks = avatarRenderState.ageInTicks;

        if (pack.isStarted()&&pState.getIndex()!=-1) {
            Entry entry = animations[pState.getIndex()];
            if (pState.state()== PlayerAnimationState.AnimationState.MOUNT)
                pack.update(entry.index(), entry.animation(), ageInTicks);
            else pack.update(entry.index(), entry.animation(), ageInTicks, 1.2f);

        }

        Vector3f offset = new Vector3f(body.x, body.y, body.z);
        Vector3f offsetRot = new Vector3f(body.xRot, body.yRot, body.zRot);

        for (ModelPart part : bodyParts) {
            part.offsetPos(offset);
            part.offsetRotation(offsetRot);
        }
        //57.29577951308232


    }

    public record Entry(ModelAnimation animation, int index){}

}
