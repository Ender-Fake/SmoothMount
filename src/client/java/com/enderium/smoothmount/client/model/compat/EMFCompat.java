package com.enderium.smoothmount.client.model.compat;

import com.enderium.smoothmount.client.util.ModelUtils;
import net.minecraft.client.model.geom.ModelPart;

import java.util.Optional;

public class EMFCompat {

    public static final Runnable EMPTY_FUNCTION = () -> {
    };


    public static void freshCapeOffset(ModelPart part) {
        part.z -= 3;

    }

    public static Runnable getModelFunction(ModelPart root) {

        Optional<ModelPart> part = ModelUtils.getPart(root, "body", "cape", "EMF_cape", "EMF_cloak", "EMF_cloak2");

        if (part.isPresent()) {
            return new Runnable() {

                private final ModelPart cape = part.get();

                @Override
                public void run() {

                    freshCapeOffset(cape);

                }
            };


        }

        return EMPTY_FUNCTION;
    }
}
