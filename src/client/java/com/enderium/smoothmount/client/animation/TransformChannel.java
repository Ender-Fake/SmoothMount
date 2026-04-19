package com.enderium.smoothmount.client.animation;

import org.joml.Vector3f;

public record TransformChannel(TransformTrack track, VectorChannel position, VectorChannel rotation,
                               VectorChannel scale) implements IndexedAnimation {

    @Override
    public void update(float time, int index, int[] gIndices) {
        position.update(time, index, gIndices);
        rotation.update(time, index + 1, gIndices);
        scale.update(time, index + 2, gIndices);
    }

    @Override
    public int getIndexCount() {
        return 3;
    }

    public Vector3f getPosition() {
        return position.currentValue;
    }

    public Vector3f getRotation() {
        return rotation.currentValue;
    }

    public Vector3f getScale() {
        return scale.currentValue;
    }


}
