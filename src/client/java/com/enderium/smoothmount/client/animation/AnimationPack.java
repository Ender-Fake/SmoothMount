package com.enderium.smoothmount.client.animation;

import com.enderium.smoothmount.client.animation.definition.AnimationChannel;

public record AnimationPack(AnimationState state, AnimationInstance... pack) {

    public static AnimationPack of(IndexProvider... pack) {
        return of(new AnimationState(), pack);
    }

    public static AnimationPack of(AnimationState state, IndexProvider... pack) {
        AnimationPack animPack = new AnimationPack(state, new AnimationInstance[pack.length]);
        for (int i = 0; i < pack.length; i++) {
            animPack.pack[i] = AnimationInstance.of(pack[i], state);
        }
        return animPack;
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
