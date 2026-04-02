package com.enderium.smoothmount.client.model;

import net.minecraft.client.model.geom.ModelPart;

import java.util.Map;

public interface ModelPartChildren {

    Map<String, ModelPart> children();

    void resetPoseAndChildren();

    default void resetPoseOnlyChildren(){
        for (ModelPart value : children().values()) {
            ((ModelPartChildren)value).resetPoseAndChildren();
        }
    }

}
