package com.enderium.smoothmount.mixin.client;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {

    public LivingEntityMixin(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }


    /*@Inject(method = "stopRiding", at = @At(value = "TAIL"))
    public void dismount(CallbackInfo ci){
        if (!(((Object) this) instanceof Player player)) return;
        if (!player.level().isClientSide()) return;

        //startRidingTime = System.nanoTime();
        //lastMountPos = player.oldPosition();




    }*/




}
