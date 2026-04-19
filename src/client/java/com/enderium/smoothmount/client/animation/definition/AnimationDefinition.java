package com.enderium.smoothmount.client.animation.definition;

import com.enderium.smoothmount.client.animation.IndexProvider;

public interface AnimationDefinition extends IndexProvider {

    float lengthInSeconds();

    boolean looping();

    default boolean autoStop() {
        return true;
    }

    default float getElapsedSeconds(long l) {
        float f = (float) l / 1000.0f;
        return looping() ? f % lengthInSeconds() : f;
    }

}
