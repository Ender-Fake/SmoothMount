package com.enderium.smoothmount.mixin.client;

import com.enderium.smoothmount.client.render.EntityRenderExtra;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityRenderer.class)
public class EntityRendererMixin  {

    @Inject(method = "extractRenderState", at = @At("HEAD"))
    public void extractExtra(Entity entity, EntityRenderState entityRenderState, float f, CallbackInfo ci){
        EntityRenderExtra state = (EntityRenderExtra) entityRenderState;
        state.setTick(entity.tickCount);
        state.setDelta(f);
    }



}
