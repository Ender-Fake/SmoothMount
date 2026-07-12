package com.enderium.smoothmount.client.model.animation.entity;

public class AnimationContext {

    public static final AnimationContext DEFAULT = of(1);

    private float timeScale;


    public float timeScale() {
        return timeScale;
    }

    public static AnimationContext of(float timeScale) {
        AnimationContext context = new AnimationContext();
        context.timeScale = timeScale;
        return context;
    }

}
