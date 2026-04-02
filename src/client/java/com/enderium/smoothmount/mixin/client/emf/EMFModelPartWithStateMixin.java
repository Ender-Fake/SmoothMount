package com.enderium.smoothmount.mixin.client.emf;


import com.enderium.smoothmount.compat.OtherRenderPart;
import com.enderium.smoothmount.mixin.client.accesor.ModelPartAccessor;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelPart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import traben.entity_model_features.models.parts.EMFModelPart;
import traben.entity_model_features.models.parts.EMFModelPartWithState;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.List;
import java.util.Map;

@Debug(export = true)
//@Mixin(targets = "traben.entity_model_features.models.parts.EMFModelPartWithState", remap = false, priority = 1050)
@Mixin(value = EMFModelPartWithState.class, /*remap = false,*/ priority = 1050)
public abstract class EMFModelPartWithStateMixin extends EMFModelPart implements OtherRenderPart {

    @Unique
    private static final Logger log = LoggerFactory.getLogger(EMFModelPartWithStateMixin.class);
    @Unique
    private static MethodHandle vanillaRender=null;


    static {
        try {
            Class<?> aClass = Class.forName("traben.entity_model_features.models.parts.EMFModelPartWithState");
            log.info("[SmoothMount] EMF detected! Compatibility mode enabled.");
            MethodHandles.Lookup lookup = MethodHandles.lookup();
            vanillaRender = lookup.findVirtual(aClass, "renderLikeVanilla", MethodType.methodType(Void.TYPE, PoseStack.class, VertexConsumer.class, int.class, int.class, int.class));

        } catch (ClassNotFoundException e) {
            //smoothmount$emfDetected = false;
            log.warn("[SmoothMount] EMF not detected.");
        } catch (NoSuchMethodException | IllegalAccessException e) {
            log.error("Find Error",e);
        }
    }

    @Unique
    private boolean useVanilla;

    public EMFModelPartWithStateMixin(List<Cube> cuboids, Map<String, ModelPart> children) {
        super(cuboids, children);
    }


    @Inject(method = "render(Lcom/mojang/blaze3d/vertex/PoseStack;Lcom/mojang/blaze3d/vertex/VertexConsumer;III)V",
    //@Inject(method = "render(Ljava/lang/Object;Ljava/lang/Object;III)V",
            at = @At("HEAD"), /*remap = false,*/ cancellable = true)
    //public void fixRender(PoseStack poseStack, VertexConsumer vertexConsumer, int i, int j, int k, CallbackInfo ci) {
    public void fixRender(PoseStack matrices, VertexConsumer vertices, int light, int overlay, int k, CallbackInfo ci) {
        if (useVanilla()) try {
            vanillaRender.invokeExact(this,matrices,vertices,light,overlay,k);
            ci.cancel();
        } catch (Throwable e) {
            log.error("Invoke Error",e);
        }


    }

    @Override
    public boolean useVanilla() {
        return useVanilla;
    }

    @Override
    public void enableVanilla(boolean vanilla) {
        if (useVanilla==vanilla)return;
        useVanilla = vanilla;
        for (ModelPart value : ((ModelPartAccessor) this).children().values()) {
            if (value instanceof OtherRenderPart part)part.enableVanilla(vanilla);
        }

    }
}
