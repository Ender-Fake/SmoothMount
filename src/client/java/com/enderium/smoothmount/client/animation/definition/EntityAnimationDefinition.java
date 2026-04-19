package com.enderium.smoothmount.client.animation.definition;

import com.enderium.smoothmount.client.animation.TransformTrack;
import com.google.common.collect.Maps;

import java.util.Map;

public record EntityAnimationDefinition(float lengthInSeconds, boolean looping,
                                        Map<String, TransformTrack> keyAnimations) implements AnimationDefinition {


    public EntityAnimation bake() {
        return EntityAnimation.bake(this);
    }

    @Override
    public int getIndexCount() {
        return keyAnimations.size() * 3;
    }

    public static class Builder {
        private final float length;
        private final Map<String, TransformTrack> animationByBone = Maps.newHashMap();
        private boolean looping;

        public static EntityAnimationDefinition.Builder withLength(float t) {
            return new EntityAnimationDefinition.Builder(t);
        }

        private Builder(float t) {
            this.length = t;
        }

        public EntityAnimationDefinition.Builder looping() {
            this.looping = true;
            return this;
        }

        public EntityAnimationDefinition.Builder addAnimation(String name, TransformTrack track) {
            this.animationByBone.put(name, track);
            return this;
        }

        public EntityAnimationDefinition build() {
            return new EntityAnimationDefinition(this.length, this.looping, this.animationByBone);
        }
    }

}
