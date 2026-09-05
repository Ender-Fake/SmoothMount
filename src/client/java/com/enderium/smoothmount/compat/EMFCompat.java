package com.enderium.smoothmount.compat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import traben.entity_model_features.EMFAnimationApi;
import traben.entity_model_features.utils.EMFEntity;

import java.util.HashSet;

public class EMFCompat {

    private static final Logger log = LoggerFactory.getLogger(EMFCompat.class);

    private static final HashSet<EMFEntity> disabledEntities=new HashSet<>();


    public static void init() {

        try {
/*            EMFAnimationApi.registerAnimationHook(new EMFAnimationApi.EMFAnimationHook() {
                @Override
                public boolean onAnimationStart(AnimationContext context, boolean isCancelledByHook) {

                    context.animatingModelRoot();


                    return true;
//                    return !isCancelledByHook;
                }
            });*/

            EMFAnimationApi.registerPauseCondition(emfEntity -> {
                if (emfEntity.etf$isBlockEntity())return false;
                return disabledEntities.contains(emfEntity);
            });

        } catch (Exception e) {
            log.error("EMF compat not load", e);
        }

    }


    public static void disableAnimation() {
        disabledEntities.add(EMFAnimationApi.getCurrentEntity());


    }

    public static void enableAnimation() {
        disabledEntities.remove(EMFAnimationApi.getCurrentEntity());

    }

}
