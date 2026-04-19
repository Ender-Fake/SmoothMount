package com.enderium.smoothmount.client.animation;

import org.joml.Vector3f;

public class VectorChannel implements IndexedAnimation {

    public static final VectorChannel EMPTY = new EmptyVectorChannel();

    private final VectorTrack track;
    public final Vector3f currentValue = new Vector3f();

    public VectorChannel(VectorTrack initialTrack) {
        this.track = initialTrack;
    }

    public Vector3f apply(float time, int index, int[] gIndices) {
        update(time, index, gIndices);
        return currentValue;
    }

    public void update(float time, int index, int[] gIndices) {
        if (track == null) {
            currentValue.zero();
            return;
        }

        float[] times = track.timestamps;
        int len = times.length;
        int currentIndex = gIndices[index];

        if (time <= times[0]) currentIndex = 0;
        else if (time >= times[len - 1]) currentIndex = len - 1;
        else {
            while (currentIndex < len - 2 && time >= times[currentIndex + 1]) currentIndex++;
            while (currentIndex > 0 && time < times[currentIndex]) currentIndex--;
        }

        gIndices[index] = currentIndex;

        track.evaluate(currentValue, currentIndex, time);
    }

    public VectorTrack getTrack() {
        return track;
    }

    @Override
    public int getIndexCount() {
        return track.getIndexCount();
    }

    private static class EmptyVectorChannel extends VectorChannel {
        public EmptyVectorChannel() {
            super(VectorTrack.empty());
        }

        @Override
        public void update(float time, int index, int[] gIndices) {
            //currentValue.zero();
        }
    }

}
