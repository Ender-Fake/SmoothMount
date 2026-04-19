package com.enderium.smoothmount.client.animation.definition;

import com.enderium.smoothmount.client.animation.TransformChannel;
import it.unimi.dsi.fastutil.objects.Object2ObjectMaps;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;

import java.util.HashMap;
import java.util.Map;

public class EntityAnimation implements AnimationChannel {
    private final EntityAnimationDefinition definition;
    private final Map<String, TransformChannel> channelMap;

    private final TransformChannel offsetTransform;


    private EntityAnimation(EntityAnimationDefinition definition, Map<String, TransformChannel> channelMap) {
        this.definition = definition;
        this.channelMap = channelMap;

        offsetTransform = channelMap.get("o_transform");

    }

    public static EntityAnimation bake(EntityAnimationDefinition definition) {

        HashMap<String, TransformChannel> channelMap = new HashMap<>();
        for (var entry : definition.keyAnimations().entrySet())
            channelMap.put(entry.getKey(), entry.getValue().createChannel());
        return new EntityAnimation(definition, channelMap);
    }

    @Override
    public void update(float time, int index, int[] gIndices) {
        for (TransformChannel entry : channelMap.values()) {
            entry.update(time, index, gIndices);
            index += 3;
        }
    }

    @Override
    public float lengthInSeconds() {
        return definition.lengthInSeconds();
    }

    @Override
    public boolean looping() {
        return definition.looping();
    }

    @Override
    public int getIndexCount() {
        return definition.getIndexCount();
    }

    public TransformChannel offsetTransform() {
        return offsetTransform;
    }

    public EntityAnimationDefinition definition() {
        return definition;
    }

    public Map<String, TransformChannel> channelMap() {
        return channelMap;
    }

    public TransformChannel get(String name) {
        return channelMap.get(name);
    }


}
