package com.enderium.smoothmount.client.util;

import net.minecraft.client.model.geom.ModelPart;

import java.text.NumberFormat;
import java.util.Optional;

public class ModelUtils {

    private static final NumberFormat format = NumberFormat.getNumberInstance();

    public static Optional<ModelPart> getPart(ModelPart root, String path) {
        String[] split = path.split("\\.");
        if (split.length == 0) {
            return root.hasChild(path) ? Optional.of(root.getChild(path)) : Optional.empty();
        }
        ModelPart part = root;
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            if (part.hasChild(s)) {
                part = part.getChild(s);
            } else return Optional.empty();
        }
        return Optional.of(part);
    }

    public static String toString(ModelPart part){
        return format.format(part.x)+" "+format.format(part.y)+" "+format.format(part.z);
    }
}
