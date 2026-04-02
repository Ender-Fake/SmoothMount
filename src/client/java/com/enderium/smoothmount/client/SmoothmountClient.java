package com.enderium.smoothmount.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.Minecraft;
import net.minecraft.world.phys.Vec3;

public class SmoothmountClient implements ClientModInitializer {
    private static SmoothmountClient instance;

    public SmoothmountClient(){
        instance=this;
    }



    @Override
    public void onInitializeClient() {

        //EntityRenderDispatcher
        ClientTickEvents.END_CLIENT_TICK.register(this::onEndTick);
        ClientTickEvents.START_CLIENT_TICK.register(client -> {
            if (client.player==null)return;
            lastPlayerPosStart = client.player.position();

        });

    }

    private Vec3 lastPlayerPos;
    private Vec3 lastPlayerPosStart;

    private void onEndTick(Minecraft client) {
        if (client.player==null)return;
        lastPlayerPos = client.player.oldPosition();

    }


    public Vec3 lastPlayerPos() {
        return lastPlayerPos;
    }

    public Vec3 lastPlayerPosStart() {
        return lastPlayerPosStart;
    }

    public static SmoothmountClient instance() {
        return instance;
    }
}
