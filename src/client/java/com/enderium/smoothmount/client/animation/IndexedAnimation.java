package com.enderium.smoothmount.client.animation;

public interface IndexedAnimation extends IndexProvider {

    void update(float time, int index, int[] gIndices);

}
