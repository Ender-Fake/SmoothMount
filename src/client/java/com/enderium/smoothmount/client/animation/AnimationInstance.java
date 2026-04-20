package com.enderium.smoothmount.client.animation;

import com.enderium.smoothmount.client.animation.definition.AnimationChannel;


public record AnimationInstance(IndexInstance sharedIndices, int offset, int length, AnimationTimer timer) {

    public static AnimationInstance of(IndexProvider provider, AnimationTimer timeState) {
        IndexInstance indices = new IndexInstance(provider.getIndexCount());
        return new AnimationInstance(indices, 0, indices.length, timeState);
    }

    public void start() {
        sharedIndices.clearRange(offset, length);
    }

    public void update(AnimationChannel channel, float time) {
        channel.update(timer, time, offset, sharedIndices.index);
    }

    public void update(AnimationChannel channel, float time, float scale) {
        channel.update(timer, scale, time, offset, sharedIndices.index);
    }


}
