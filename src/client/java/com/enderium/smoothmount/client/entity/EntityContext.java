package com.enderium.smoothmount.client.entity;

import net.minecraft.world.phys.Vec3;

public interface EntityContext {

    int tickCount();

    Vec3 getPos();

    float yBodyRot();

    float yRot();

    float xRot();



}
