package com.enderium.smoothmount.compat;

public class ModelCompat {


    public static void animationStart() {

        EMFCompat.disableAnimation();

    }

    public static void animationStop() {

        EMFCompat.enableAnimation();

    }

}
