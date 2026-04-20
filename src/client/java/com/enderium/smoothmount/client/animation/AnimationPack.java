package com.enderium.smoothmount.client.animation;

import com.enderium.smoothmount.client.animation.definition.AnimationChannel;

public record AnimationPack(AnimationTimer state, IndexInstance sharedIndices, AnimationInstance... pack) {

    public static AnimationPack of(IndexProvider... providers) {
        return of(new AnimationTimer(), providers);
    }

    public static AnimationPack of(AnimationTimer state, IndexProvider... providers) {
        int totalSize = 0;
        for (IndexProvider p : providers) totalSize += p.getIndexCount();
        IndexInstance sharedIndices = new IndexInstance(totalSize);
        AnimationInstance[] instances = new AnimationInstance[providers.length];
        int currentOffset = 0;
        for (int i = 0; i < providers.length; i++) {
            IndexProvider provider = providers[i];
            int count = provider.getIndexCount();
            instances[i] = new AnimationInstance(sharedIndices, currentOffset, count, state);
            currentOffset += count;
        }
        return new AnimationPack(state, sharedIndices, instances);
    }

    public void start(int i, int ticks) {
        pack[i].start();
        state.start(ticks);
    }

    public void update(int i, AnimationChannel channel, float time) {
        pack[i].update(channel, time);
    }

    public void update(int i, AnimationChannel channel, float time, float scale) {
        pack[i].update(channel, time, scale);
    }

    public boolean isStarted() {
        return state.isStarted();
    }

    public boolean isStopped() {
        return state.isStopped();
    }

}
