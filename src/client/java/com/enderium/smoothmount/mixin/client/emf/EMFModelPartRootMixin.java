package com.enderium.smoothmount.mixin.client.emf;

import com.enderium.smoothmount.compat.OtherRenderPart;
import com.mojang.blaze3d.vertex.PoseStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import traben.entity_model_features.models.parts.EMFModelPartRoot;

//@Debug(export = true)
@Mixin(EMFModelPartRoot.class)
public class EMFModelPartRootMixin {


    @Inject(method = "triggerManualAnimation", at = @At("HEAD"), cancellable = true)
    public void cancelArms(PoseStack matrices, CallbackInfo ci) {
        if (((OtherRenderPart) this).useVanilla()) ci.cancel();

    }


}
