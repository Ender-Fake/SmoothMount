package com.enderium.smoothmount.client.util;

import net.minecraft.client.model.geom.ModelPart;

import java.text.NumberFormat;
import java.util.Optional;

public class ModelUtils {

    private static final NumberFormat format = NumberFormat.getNumberInstance();

    public static Optional<ModelPart> getPart(ModelPart root, String path) {
        String[] parts = path.split("\\.");
        if (parts.length == 0) return root.hasChild(path) ? Optional.of(root.getChild(path)) : Optional.empty();
        return getPart(root, parts);
    }

    public static Optional<ModelPart> getPart(ModelPart root, String... parts) {
        ModelPart currentPart = root;
        for (String part : parts) {
            if (!currentPart.hasChild(part)) return Optional.empty();
            currentPart = currentPart.getChild(part);
        }
        return Optional.of(currentPart);
    }


    public static String toString(ModelPart part) {
        return format.format(part.x) + " " + format.format(part.y) + " " + format.format(part.z);
    }
}
