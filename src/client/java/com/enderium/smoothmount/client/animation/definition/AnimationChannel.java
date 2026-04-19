package com.enderium.smoothmount.client.animation.definition;

import com.enderium.smoothmount.client.animation.AnimationState;
import com.enderium.smoothmount.client.animation.IndexedAnimation;

public interface AnimationChannel extends AnimationDefinition, IndexedAnimation {


    default void update(AnimationState state, float time, int index, int[] gIndices) {
        update(state, 1, time, index, gIndices);
    }

    default void update(AnimationState state, float scale, float time, int index, int[] gIndices) {
        if (state.isStopped()) return;
        long scaledTime = (long) ((float) state.getTimeInMillis(time) * scale);
        update(getElapsedSeconds(scaledTime), index, gIndices);
        if (autoStop()) state.timeout(scaledTime, this);
    }

}
