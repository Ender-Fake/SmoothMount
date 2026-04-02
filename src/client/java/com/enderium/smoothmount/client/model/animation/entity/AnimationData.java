package com.enderium.smoothmount.client.model.animation.entity;

import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.world.entity.AnimationState;

public interface AnimationData {


    static boolean timeout(float time, AnimationState state, AnimationDefinition definition){
        if (state.isStarted()&&state.getTimeInMillis(time)/1000f > definition.lengthInSeconds()){
            state.stop();
            return true;
        }
        return false;
    }

}
