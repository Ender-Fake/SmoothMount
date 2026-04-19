package com.enderium.smoothmount.client.animation;

import com.enderium.smoothmount.client.animation.definition.AnimationChannel;


public record AnimationInstance(IndexInstance index, AnimationState timeState) {

    public static AnimationInstance of(IndexProvider provider, AnimationState timeState) {
        return new AnimationInstance(new IndexInstance(provider.getIndexCount()), timeState);
    }

    public void update(AnimationChannel channel, float time) {
        channel.update(timeState, time, 0, index.index);
    }

    public void update(AnimationChannel channel, float time, float scale) {
        channel.update(timeState, scale, time, 0, index.index);
    }


}
