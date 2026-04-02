package com.enderium.smoothmount.mixin.client;

import com.enderium.smoothmount.client.model.ModelPartChildren;
import net.minecraft.client.model.geom.ModelPart;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Map;

@Mixin(ModelPart.class)
public abstract class ModelPartMixin implements ModelPartChildren {
    @Shadow
    @Final
    private Map<String, ModelPart> children;

    @Shadow
    public abstract void resetPose();

    @Override
    public Map<String, ModelPart> children() {
        return children;
    }

    @Override
    public void resetPoseAndChildren() {
        resetPose();
        for (ModelPart value : children.values()) {
            ((ModelPartChildren)value).resetPoseAndChildren();
        }
    }
}
