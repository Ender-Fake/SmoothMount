package com.enderium.smoothmount.client.animation.definition;

import com.enderium.smoothmount.client.animation.TransformTrack;
import com.google.common.collect.Maps;
import net.minecraft.client.model.geom.ModelPart;

import java.util.Map;

public record ModelAnimationDefinition(float lengthInSeconds, boolean looping,
                                       Map<String, TransformTrack> boneAnimations) implements AnimationDefinition {


    public ModelAnimation bake(ModelPart part) {
        return ModelAnimation.bake(part, this);
    }

    @Override
    public int getIndexCount() {
        return boneAnimations.size() * 3;
    }

    public static class Builder {
        private final float length;
        private final Map<String, TransformTrack> animationByBone = Maps.newHashMap();
        private boolean looping;

        public static ModelAnimationDefinition.Builder withLength(float t) {
            return new ModelAnimationDefinition.Builder(t);
        }

        private Builder(float t) {
            this.length = t;
        }

        public ModelAnimationDefinition.Builder looping() {
            this.looping = true;
            return this;
        }

        public ModelAnimationDefinition.Builder addAnimation(String boneName, TransformTrack track) {
            this.animationByBone.put(boneName, track);
            return this;
        }

        public ModelAnimationDefinition build() {
            return new ModelAnimationDefinition(this.length, this.looping, this.animationByBone);
        }
    }

}
