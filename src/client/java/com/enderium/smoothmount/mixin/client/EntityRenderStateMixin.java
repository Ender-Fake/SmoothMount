package com.enderium.smoothmount.mixin.client;

import com.enderium.smoothmount.client.render.EntityRenderExtra;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(EntityRenderState.class)
public class EntityRenderStateMixin implements EntityRenderExtra {
    @Unique
    private int tick;
    @Unique
    private float delta;


    @Override
    public int getTick() {
        return tick;
    }

    @Override
    public float getDelta() {
        return delta;
    }

    @Override
    public void setTick(int tick) {
        this.tick = tick;
    }

    @Override
    public void setDelta(float delta) {
        this.delta = delta;
    }

}
