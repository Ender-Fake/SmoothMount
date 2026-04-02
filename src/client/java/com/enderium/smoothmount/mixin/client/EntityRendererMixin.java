package com.enderium.smoothmount.mixin.client;

import com.enderium.smoothmount.client.render.EntityRenderExtra;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityRenderer.class)
public class EntityRendererMixin implements EntityRenderExtra {
    @Unique
    private int tick;
    @Unique
    private float delta;
    @Inject(method = "extractRenderState", at = @At("HEAD"))
    public void extractExtra(Entity entity, EntityRenderState entityRenderState, float f, CallbackInfo ci){
        tick = entity.tickCount;
        delta=f;
    }



    @Override
    public int getTick() {
        return tick;
    }

    @Override
    public float getDelta() {
        return delta;
    }
}
