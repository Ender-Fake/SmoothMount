package com.enderium.smoothmount.mixin.client;


import com.enderium.smoothmount.client.animation.AnimationPack;
import com.enderium.smoothmount.client.animation.definition.ModelAnimation;
import com.enderium.smoothmount.client.model.animation.entity.AnimationContext;
import com.enderium.smoothmount.client.model.animation.entity.AnimationType;
import com.enderium.smoothmount.client.model.animation.entity.PlayerAnimationState;
import com.enderium.smoothmount.client.model.compat.EMFModelCompat;
import com.enderium.smoothmount.compat.ModelCompat;
import com.enderium.smoothmount.compat.OtherRenderPart;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.player.PlayerModel;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import net.minecraft.util.Mth;
import org.joml.Vector3f;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Mixin(value = PlayerModel.class, priority = 5000)
public class PlayerModelMixin extends HumanoidModel<AvatarRenderState> {

    @Unique
    private Entry[] animations;

    @Unique
    private final List<ModelPart> smBodyParts = new ArrayList<>();
    /* @Unique
    private final List<ModelPart> smBodyPartsResetMount = List.of(leftLeg, rightLeg, leftArm, rightArm);
    @Unique
    private final List<ModelPart> smBodyPartsResetDismount = List.of(leftLeg, rightLeg);
    */

    @Mutable
    @Final
    @Unique
    private Runnable emfCompat;

    public PlayerModelMixin(ModelPart modelPart) {
        super(modelPart);
    }

    @Inject(method = "<init>", at = @At("TAIL"))
    public void init(ModelPart modelPart, boolean bl, CallbackInfo ci) {
        animations = Arrays.stream(AnimationType.ANIMATIONS_M).map(e -> new Entry(e.bake(modelPart), AnimationType.INDEX_ANIMATION.getInt(e))).toArray(Entry[]::new);

        smBodyParts.addAll(List.of(leftLeg, rightLeg, leftArm, rightArm, head));

        emfCompat = EMFModelCompat.getModelFunction(modelPart);

    }


    @Inject(method = "setupAnim(Lnet/minecraft/client/renderer/entity/state/AvatarRenderState;)V",
            at = @At(value = "HEAD"), cancellable = true
    )
    public void setAnim(AvatarRenderState avatarRenderState, CallbackInfo ci) {
        PlayerAnimationState pState = (PlayerAnimationState) avatarRenderState;
        boolean b = pState.smoothMount$IsStopped();


//        if (root instanceof OtherRenderPart part) part.enableVanilla(!b);


        if (b) {
            ModelCompat.animationStop();
            return;
        }
        ModelCompat.animationStart();
        ci.cancel();
        resetPose();

        rotateHead(avatarRenderState);
        AnimationPack pack = pState.animationPack();
        AnimationContext context = pState.getContext();

        //if (pack.isStarted()) for (ModelPart part : smBodyPartsResetMount) ((ModelPartChildren) part).resetPoseAndChildren();

        float ageInTicks = avatarRenderState.ageInTicks;

        if (pack.isStarted() && pState.getIndex() != -1) {
            Entry entry = animations[pState.getIndex()];
            pack.update(entry.index(), entry.animation(), ageInTicks, context.timeScale());

        }

        Vector3f offset = new Vector3f(body.x, body.y, body.z);
        Vector3f offsetRot = new Vector3f(body.xRot, body.yRot, body.zRot);

        for (ModelPart part : smBodyParts) {
            part.offsetPos(offset);
            part.offsetRotation(offsetRot);
        }

        emfCompat.run();


    }

    @Unique
    private void rotateHead(AvatarRenderState state) {
        float f = state.swimAmount;
        boolean bl = state.isFallFlying;
        this.head.xRot = state.xRot * ((float) Math.PI / 180);
        this.head.yRot = state.yRot * ((float) Math.PI / 180);
        if (bl) {
            this.head.xRot = -0.7853982f;
        } else if (f > 0.0f) {
            this.head.xRot = Mth.rotLerpRad(f, this.head.xRot, -0.7853982f);
        }
    }

    public record Entry(ModelAnimation animation, int index) {
    }

}
