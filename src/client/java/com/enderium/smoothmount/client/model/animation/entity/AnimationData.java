package com.enderium.smoothmount.client.model.animation.entity;

import com.enderium.smoothmount.client.animation.AnimationState;
import com.enderium.smoothmount.client.animation.definition.AnimationDefinition;


public interface AnimationData {


    static boolean timeout(float time, AnimationState state, AnimationDefinition definition) {
        if (state.isStarted() && state.getTimeInMillis(time) / 1000f > definition.lengthInSeconds()) {
            state.stop();
            return true;
        }
        return false;
    }

}
