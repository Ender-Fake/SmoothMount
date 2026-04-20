package com.enderium.smoothmount.client.animation;

import com.enderium.smoothmount.client.animation.definition.AnimationDefinition;

public class AnimationTimer {
    private static final int STOPPED = Integer.MIN_VALUE;
    private int startTick = STOPPED;

    public void start(int i) {
        this.startTick = i;
    }

    public void startIfStopped(int i) {
        if (this.isStopped()) this.start(i);
    }

    public void stop() {
        this.startTick = Integer.MIN_VALUE;
    }


    public long getTimeInMillis(float t) {
        float s = t - (float) this.startTick;
        return (long) (s * 50.0f);
    }

    public int tick() {
        return startTick;
    }

    public boolean isStarted() {
        return this.startTick != STOPPED;
    }

    public boolean isStopped() {
        return this.startTick == STOPPED;
    }

    public boolean timeout(float time, AnimationDefinition definition) {
        if (isStarted() && getTimeInMillis(time) / 1000f > definition.lengthInSeconds()) {
            stop();
            return true;
        }
        return false;
    }

    public boolean timeout(long time, AnimationDefinition definition) {
        if (isStarted() && time / 1000f > definition.lengthInSeconds()) {
            stop();
            return true;
        }
        return false;
    }


}
