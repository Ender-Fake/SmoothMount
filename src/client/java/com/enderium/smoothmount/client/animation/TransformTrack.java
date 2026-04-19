package com.enderium.smoothmount.client.animation;

public record TransformTrack(VectorTrack position, VectorTrack rotation, VectorTrack scale) implements IndexProvider {

    public TransformChannel createChannel() {
        return new TransformChannel(this, position.createChannel(), rotation.createChannel(), scale.createChannel());
    }

    @Override
    public int getIndexCount() {
        return 3;
    }
}
