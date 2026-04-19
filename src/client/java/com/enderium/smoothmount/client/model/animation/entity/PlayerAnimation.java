package com.enderium.smoothmount.client.model.animation.entity;

import com.enderium.smoothmount.client.animation.TransformTrack;
import com.enderium.smoothmount.client.animation.VectorTrack;
import com.enderium.smoothmount.client.animation.definition.EntityAnimationDefinition;
import com.enderium.smoothmount.client.animation.definition.ModelAnimationDefinition;
import com.enderium.smoothmount.client.animation.definition.ModelChannels;
import org.joml.Vector3f;

public class PlayerAnimation {
    public static class Mount {
        public static final ModelAnimationDefinition MOUNT_BACK_M = ModelAnimationDefinition.Builder.withLength(0.54167F)
                .addAnimation("root", new TransformTrack(
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0.33333F, ModelChannels.posVec(-0F, 0F, 0F), VectorTrack.InterpolateMode.Linear),
                                new VectorTrack.Keyframe(0.41667F, ModelChannels.posVec(-0F, 0F, 0.75F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.45833F, ModelChannels.posVec(-0F, -0.25F, -0.25F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.54167F, ModelChannels.posVec(-0F, 0F, 0F), VectorTrack.InterpolateMode.CatmullRom)
                        ),
                        VectorTrack.empty(),
                        VectorTrack.empty()
                ))
                .addAnimation("head", new TransformTrack(
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0F, ModelChannels.posVec(-0F, 0F, 0F), VectorTrack.InterpolateMode.Linear)
                        ),
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0F, ModelChannels.degreeVec(-37.5F, -0F, 0F), VectorTrack.InterpolateMode.Linear),
                                new VectorTrack.Keyframe(0.5F, ModelChannels.degreeVec(-0F, -0F, 0F), VectorTrack.InterpolateMode.CatmullRom)
                        ),
                        VectorTrack.empty()
                ))
                .addAnimation("body", new TransformTrack(
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0F, ModelChannels.posVec(-0F, 0F, 0F), VectorTrack.InterpolateMode.Linear)
                        ),
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0F, ModelChannels.degreeVec(37.5F, -0F, 0F), VectorTrack.InterpolateMode.Linear),
                                new VectorTrack.Keyframe(0.5F, ModelChannels.degreeVec(-0F, -0F, 0F), VectorTrack.InterpolateMode.CatmullRom)
                        ),
                        VectorTrack.empty()
                ))
                .addAnimation("right_arm", new TransformTrack(
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0F, ModelChannels.posVec(-0F, 0F, 0F), VectorTrack.InterpolateMode.Linear)
                        ),
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0F, ModelChannels.degreeVec(-56.593407F, -12.608368F, -8.192523F), VectorTrack.InterpolateMode.Linear),
                                new VectorTrack.Keyframe(0.25F, ModelChannels.degreeVec(-17.046703F, -6.304184F, -4.0962615F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.5F, ModelChannels.degreeVec(-36F, -0F, 0F), VectorTrack.InterpolateMode.CatmullRom)
                        ),
                        VectorTrack.empty()
                ))
                .addAnimation("left_arm", new TransformTrack(
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0F, ModelChannels.posVec(-0F, 0F, 0F), VectorTrack.InterpolateMode.Linear)
                        ),
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0F, ModelChannels.degreeVec(-56.593407F, 12.608368F, 8.192523F), VectorTrack.InterpolateMode.Linear),
                                new VectorTrack.Keyframe(0.25F, ModelChannels.degreeVec(-17.046703F, 6.304184F, 4.0962615F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.5F, ModelChannels.degreeVec(-36F, -0F, 0F), VectorTrack.InterpolateMode.CatmullRom)
                        ),
                        VectorTrack.empty()
                ))
                .addAnimation("right_leg", new TransformTrack(
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0F, ModelChannels.posVec(-0F, 0F, 0F), VectorTrack.InterpolateMode.Linear),
                                new VectorTrack.Keyframe(0.125F, ModelChannels.posVec(-2F, 2.0527935F, -1.9138426F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.25F, ModelChannels.posVec(-4F, 2.2152996F, -0.3040512F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.375F, ModelChannels.posVec(-2.88F, 3.4032867F, 0.22579095F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.5F, ModelChannels.posVec(-0F, 0F, 0F), VectorTrack.InterpolateMode.CatmullRom)
                        ),
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0F, ModelChannels.degreeVec(-37.5F, -0F, 0F), VectorTrack.InterpolateMode.Linear),
                                new VectorTrack.Keyframe(0.125F, ModelChannels.degreeVec(-11.169593F, 14.948227F, 5.6292915F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.25F, ModelChannels.degreeVec(-17.339186F, 29.896454F, 11.258583F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.375F, ModelChannels.degreeVec(-55.873413F, 16.771238F, -0.5388504F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.45833F, ModelChannels.degreeVec(-85.43671F, 18.38562F, -0.2694252F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.5F, ModelChannels.degreeVec(-81F, 18F, 4.5F), VectorTrack.InterpolateMode.CatmullRom)
                        ),
                        VectorTrack.empty()
                ))
                .addAnimation("left_leg", new TransformTrack(
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0F, ModelChannels.posVec(-0F, 0F, 0F), VectorTrack.InterpolateMode.Linear),
                                new VectorTrack.Keyframe(0.125F, ModelChannels.posVec(2F, 2.0527935F, -1.9138426F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.25F, ModelChannels.posVec(4F, 2.2152996F, -0.3040512F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.375F, ModelChannels.posVec(2.88F, 3.4032867F, 0.22579095F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.5F, ModelChannels.posVec(-0F, 0F, 0F), VectorTrack.InterpolateMode.CatmullRom)
                        ),
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0F, ModelChannels.degreeVec(-37.5F, -0F, 0F), VectorTrack.InterpolateMode.Linear),
                                new VectorTrack.Keyframe(0.125F, ModelChannels.degreeVec(-11.169593F, -14.948227F, -5.6292915F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.25F, ModelChannels.degreeVec(-17.339186F, -29.896454F, -11.258583F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.375F, ModelChannels.degreeVec(-55.873413F, -16.771238F, 0.5388504F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.45833F, ModelChannels.degreeVec(-85.43671F, -18.38562F, 0.2694252F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.5F, ModelChannels.degreeVec(-81F, -18F, -4.5F), VectorTrack.InterpolateMode.CatmullRom)
                        ),
                        VectorTrack.empty()
                ))
                .build();
        public static final EntityAnimationDefinition MOUNT_BACK_E = EntityAnimationDefinition.Builder.withLength(0.54167F)
                .addAnimation("o_transform", new TransformTrack(
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0F, new Vector3f(-0F, 0F, 14F), VectorTrack.InterpolateMode.Linear),
                                new VectorTrack.Keyframe(0.125F, new Vector3f(-0F, 0.5F, 10.75F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.25F, new Vector3f(-0F, 3F, 7.5F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.5F, new Vector3f(-0F, 0F, 0F), VectorTrack.InterpolateMode.CatmullRom)
                        ),
                        VectorTrack.empty(),
                        VectorTrack.empty()
                ))
                .build();
        public static final ModelAnimationDefinition MOUNT_RIGHT_M = ModelAnimationDefinition.Builder.withLength(0.75F)
                .addAnimation("root", new TransformTrack(
                        VectorTrack.empty(),
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0.29167F, ModelChannels.degreeVec(-0F, -90F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.41667F, ModelChannels.degreeVec(-0F, -57.5F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.75F, ModelChannels.degreeVec(-0F, -0F, 0F), VectorTrack.InterpolateMode.CatmullRom)
                        ),
                        VectorTrack.empty()
                ))
                .addAnimation("head", new TransformTrack(
                        VectorTrack.empty(),
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0F, ModelChannels.degreeVec(-0F, -0F, 0F), VectorTrack.InterpolateMode.Linear),
                                new VectorTrack.Keyframe(0.29167F, ModelChannels.degreeVec(-10F, 10F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.41667F, ModelChannels.degreeVec(-12.58892F, 23.70729F, -3.7828915F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.75F, ModelChannels.degreeVec(-0F, -0F, 0F), VectorTrack.InterpolateMode.CatmullRom)
                        ),
                        VectorTrack.empty()
                ))
                .addAnimation("body", new TransformTrack(
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0F, ModelChannels.posVec(-0F, 0F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.125F, ModelChannels.posVec(-0F, 0F, -0.5F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.29167F, ModelChannels.posVec(4.5F, 1.75F, -1.5F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.41667F, ModelChannels.posVec(7.7710543F, 3F, 0.21234433F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.75F, ModelChannels.posVec(-0F, 1F, 0F), VectorTrack.InterpolateMode.CatmullRom)
                        ),
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0F, ModelChannels.degreeVec(-0F, -0F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.125F, ModelChannels.degreeVec(5F, -0F, -3.75F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.29167F, ModelChannels.degreeVec(33.077785F, 14.290605F, -2.8934085F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.41667F, ModelChannels.degreeVec(17.359316F, 2.2494361F, -14.656562F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.66667F, ModelChannels.degreeVec(1.3624432F, 7.6045094F, -1.1335161F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.75F, ModelChannels.degreeVec(-0F, -0F, 0F), VectorTrack.InterpolateMode.CatmullRom)
                        ),
                        VectorTrack.empty()
                ))
                .addAnimation("right_arm", new TransformTrack(
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0F, ModelChannels.posVec(-0F, 0F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.29167F, ModelChannels.posVec(-0.097894646F, -0.6339919F, -0.46202916F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.41667F, ModelChannels.posVec(-0.07857645F, -1.9819664F, -1.3219519F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.75F, ModelChannels.posVec(-0F, 0F, 0F), VectorTrack.InterpolateMode.CatmullRom)
                        ),
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0.29167F, ModelChannels.degreeVec(-42.5F, -0F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.41667F, ModelChannels.degreeVec(-37.077232F, 6.0680923F, 7.9634066F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.75F, ModelChannels.degreeVec(-36F, -0F, 0F), VectorTrack.InterpolateMode.CatmullRom)
                        ),
                        VectorTrack.empty()
                ))
                .addAnimation("left_arm", new TransformTrack(
                        VectorTrack.empty(),
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0F, ModelChannels.degreeVec(-0F, -0F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.125F, ModelChannels.degreeVec(5.1695504F, -1.292563F, -32.44548F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.29167F, ModelChannels.degreeVec(5.430733F, -0.33593997F, -47.384785F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.41667F, ModelChannels.degreeVec(-1.2281502F, -8.512469F, -56.500782F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.75F, ModelChannels.degreeVec(-36F, -0F, 0F), VectorTrack.InterpolateMode.CatmullRom)
                        ),
                        VectorTrack.empty()
                ))
                .addAnimation("right_leg", new TransformTrack(
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0F, ModelChannels.posVec(-0F, 4F, -4F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.125F, ModelChannels.posVec(-0.99785894F, 2.0651543F, -3.9942997F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.29167F, ModelChannels.posVec(-2.4129992F, 3.00199F, -4.295716F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.41667F, ModelChannels.posVec(-3.0482955F, 1.176222F, -2.2243257F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.75F, ModelChannels.posVec(-0F, 0F, 0F), VectorTrack.InterpolateMode.CatmullRom)
                        ),
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0.125F, ModelChannels.degreeVec(-5F, -0F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.29167F, ModelChannels.degreeVec(-20.81334F, 10.418898F, 20.830748F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.41667F, ModelChannels.degreeVec(-27.28805F, 41.588326F, 26.64034F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.58333F, ModelChannels.degreeVec(-55.54666F, 43.185165F, 22.417053F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.75F, ModelChannels.degreeVec(-81F, 18F, 4.5F), VectorTrack.InterpolateMode.CatmullRom)
                        ),
                        VectorTrack.empty()
                ))
                .addAnimation("left_leg", new TransformTrack(
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0F, ModelChannels.posVec(-0F, 0F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.125F, ModelChannels.posVec(2F, 2F, -1F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.29167F, ModelChannels.posVec(2.916878F, 1.6992942F, -3.0499122F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.41667F, ModelChannels.posVec(0.6317871F, 1.1644433F, -4.505878F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.58333F, ModelChannels.posVec(0.26786703F, 0.7742961F, -0.48217776F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.75F, ModelChannels.posVec(-0F, 0F, 0F), VectorTrack.InterpolateMode.CatmullRom)
                        ),
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0F, ModelChannels.degreeVec(-0F, -0F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.125F, ModelChannels.degreeVec(-0F, -0F, -15F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.29167F, ModelChannels.degreeVec(-0F, -0F, -42.5F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.41667F, ModelChannels.degreeVec(1.7537835F, -9.846552F, -70.151085F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.58333F, ModelChannels.degreeVec(-37.569164F, -52.218216F, -57.202232F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.66667F, ModelChannels.degreeVec(-69.4403F, -45.483704F, -28.57451F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.75F, ModelChannels.degreeVec(-81F, -18F, -4.5F), VectorTrack.InterpolateMode.CatmullRom)
                        ),
                        VectorTrack.empty()
                ))
                .build();
        public static final EntityAnimationDefinition MOUNT_RIGHT_E = EntityAnimationDefinition.Builder.withLength(0.75F)
                .addAnimation("o_transform", new TransformTrack(
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0F, new Vector3f(-11.75F, -5F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.125F, new Vector3f(-11.75F, -1F, 1F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.29167F, new Vector3f(-10.75F, 0F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.41667F, new Vector3f(-10.75F, 0F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.58333F, new Vector3f(-4.72F, 0F, 0.6499996F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.75F, new Vector3f(-0F, 0F, 0F), VectorTrack.InterpolateMode.CatmullRom)
                        ),
                        VectorTrack.empty(),
                        VectorTrack.empty()
                ))
                .build();
        public static final ModelAnimationDefinition MOUNT_LEFT_M = ModelAnimationDefinition.Builder.withLength(0.75F)
                .addAnimation("root", new TransformTrack(
                        VectorTrack.empty(),
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0.29167F, ModelChannels.degreeVec(-0F, 90F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.41667F, ModelChannels.degreeVec(-0F, 57.5F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.75F, ModelChannels.degreeVec(-0F, -0F, 0F), VectorTrack.InterpolateMode.CatmullRom)
                        ),
                        VectorTrack.empty()
                ))
                .addAnimation("head", new TransformTrack(
                        VectorTrack.empty(),
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0F, ModelChannels.degreeVec(-0F, -0F, 0F), VectorTrack.InterpolateMode.Linear),
                                new VectorTrack.Keyframe(0.29167F, ModelChannels.degreeVec(-10F, -10F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.41667F, ModelChannels.degreeVec(-12.58892F, -23.70729F, 3.7828915F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.75F, ModelChannels.degreeVec(-0F, -0F, 0F), VectorTrack.InterpolateMode.CatmullRom)
                        ),
                        VectorTrack.empty()
                ))
                .addAnimation("body", new TransformTrack(
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0F, ModelChannels.posVec(-0F, 0F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.125F, ModelChannels.posVec(-0F, 0F, -0.5F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.29167F, ModelChannels.posVec(-4.5F, 1.75F, -1.5F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.41667F, ModelChannels.posVec(-7.7710543F, 3F, 0.21234433F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.75F, ModelChannels.posVec(-0F, 1F, 0F), VectorTrack.InterpolateMode.CatmullRom)
                        ),
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0F, ModelChannels.degreeVec(-0F, -0F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.125F, ModelChannels.degreeVec(5F, -0F, 3.75F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.29167F, ModelChannels.degreeVec(33.077785F, -14.290605F, 2.8934085F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.41667F, ModelChannels.degreeVec(17.359316F, -2.2494361F, 14.656562F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.66667F, ModelChannels.degreeVec(1.3624432F, -7.6045094F, 1.1335161F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.75F, ModelChannels.degreeVec(-0F, -0F, 0F), VectorTrack.InterpolateMode.CatmullRom)
                        ),
                        VectorTrack.empty()
                ))
                .addAnimation("right_arm", new TransformTrack(
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0F, ModelChannels.posVec(-0F, 0F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.29167F, ModelChannels.posVec(-0.097894646F, -0.6339919F, -0.46202916F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.41667F, ModelChannels.posVec(-0.07857645F, -1.9819664F, -1.3219519F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.75F, ModelChannels.posVec(-0F, 0F, 0F), VectorTrack.InterpolateMode.CatmullRom)
                        ),
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0F, ModelChannels.degreeVec(-0F, -0F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.125F, ModelChannels.degreeVec(5.1695504F, 1.292563F, 32.44548F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.29167F, ModelChannels.degreeVec(5.430733F, 0.33593997F, 47.384785F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.41667F, ModelChannels.degreeVec(-1.2281502F, 8.512469F, 56.500782F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.75F, ModelChannels.degreeVec(-36F, -0F, 0F), VectorTrack.InterpolateMode.CatmullRom)
                        ),
                        VectorTrack.empty()
                ))
                .addAnimation("left_arm", new TransformTrack(
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0F, ModelChannels.posVec(-0F, 0F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.29167F, ModelChannels.posVec(0.097894646F, -0.6339919F, -0.46202916F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.41667F, ModelChannels.posVec(0.07857645F, -1.9819664F, -1.3219519F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.75F, ModelChannels.posVec(-0F, 0F, 0F), VectorTrack.InterpolateMode.CatmullRom)
                        ),
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0.29167F, ModelChannels.degreeVec(-42.5F, -0F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.41667F, ModelChannels.degreeVec(-37.077232F, -6.0680923F, -7.9634066F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.75F, ModelChannels.degreeVec(-36F, -0F, 0F), VectorTrack.InterpolateMode.CatmullRom)
                        ),
                        VectorTrack.empty()
                ))
                .addAnimation("right_leg", new TransformTrack(
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0F, ModelChannels.posVec(-0F, 0F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.125F, ModelChannels.posVec(-2F, 2F, -1F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.29167F, ModelChannels.posVec(-2.916878F, 1.6992942F, -3.0499122F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.41667F, ModelChannels.posVec(-0.6317871F, 1.1644433F, -4.505878F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.58333F, ModelChannels.posVec(-0.26786703F, 0.7742961F, -0.48217776F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.75F, ModelChannels.posVec(-0F, 0F, 0F), VectorTrack.InterpolateMode.CatmullRom)
                        ),
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0F, ModelChannels.degreeVec(-0F, -0F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.125F, ModelChannels.degreeVec(-0F, -0F, 15F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.29167F, ModelChannels.degreeVec(-0F, -0F, 42.5F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.41667F, ModelChannels.degreeVec(1.7537835F, 9.846552F, 70.151085F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.58333F, ModelChannels.degreeVec(-37.569164F, 52.218216F, 57.202232F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.66667F, ModelChannels.degreeVec(-69.4403F, 45.483704F, 28.57451F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.75F, ModelChannels.degreeVec(-81F, 18F, 4.5F), VectorTrack.InterpolateMode.CatmullRom)
                        ),
                        VectorTrack.empty()
                ))
                .addAnimation("left_leg", new TransformTrack(
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0F, ModelChannels.posVec(-0F, 4F, -4F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.125F, ModelChannels.posVec(0.99785894F, 2.0651543F, -3.9942997F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.29167F, ModelChannels.posVec(2.4129992F, 3.00199F, -4.295716F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.41667F, ModelChannels.posVec(3.0482955F, 1.176222F, -2.2243257F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.58333F, ModelChannels.posVec(0.26786703F, 0.7742961F, -0.48217776F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.75F, ModelChannels.posVec(-0F, 0F, 0F), VectorTrack.InterpolateMode.CatmullRom)
                        ),
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0.125F, ModelChannels.degreeVec(-5F, -0F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.29167F, ModelChannels.degreeVec(-20.81334F, -10.418898F, -20.830748F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.41667F, ModelChannels.degreeVec(-27.28805F, -41.588326F, -26.64034F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.58333F, ModelChannels.degreeVec(-55.54666F, -43.185165F, -22.417053F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.75F, ModelChannels.degreeVec(-81F, -18F, -4.5F), VectorTrack.InterpolateMode.CatmullRom)
                        ),
                        VectorTrack.empty()
                ))
                .build();
        public static final EntityAnimationDefinition MOUNT_LEFT_E = EntityAnimationDefinition.Builder.withLength(0.75F)
                .addAnimation("o_transform", new TransformTrack(
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0F, new Vector3f(11.75F, -5F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.125F, new Vector3f(11.75F, -1F, 1F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.29167F, new Vector3f(10.75F, 0F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.41667F, new Vector3f(10.75F, 0F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.58333F, new Vector3f(4.72F, 0F, 0.6499996F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.75F, new Vector3f(-0F, 0F, 0F), VectorTrack.InterpolateMode.CatmullRom)
                        ),
                        VectorTrack.empty(),
                        VectorTrack.empty()
                ))
                .build();
    }

    public static class Dismount {
        public static final ModelAnimationDefinition DISMOUNT_BACK_M = ModelAnimationDefinition.Builder.withLength(0.75F)
                .addAnimation("root", new TransformTrack(
                        VectorTrack.empty(),
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0F, ModelChannels.degreeVec(-0F, -0F, 0F), VectorTrack.InterpolateMode.Linear),
                                new VectorTrack.Keyframe(0.5F, ModelChannels.degreeVec(-0F, -0F, 0F), VectorTrack.InterpolateMode.CatmullRom)
                        ),
                        VectorTrack.empty()
                ))
                .addAnimation("head", new TransformTrack(
                        VectorTrack.empty(),
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0F, ModelChannels.degreeVec(-0F, -0F, 0F), VectorTrack.InterpolateMode.Linear),
                                new VectorTrack.Keyframe(0.125F, ModelChannels.degreeVec(2.5F, -0F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.25F, ModelChannels.degreeVec(17.5F, -0F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.5F, ModelChannels.degreeVec(-5F, -0F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.625F, ModelChannels.degreeVec(12.5F, -0F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.75F, ModelChannels.degreeVec(-0F, -0F, 0F), VectorTrack.InterpolateMode.CatmullRom)
                        ),
                        VectorTrack.empty()
                ))
                .addAnimation("body", new TransformTrack(
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0F, ModelChannels.posVec(-0F, 0F, 0F), VectorTrack.InterpolateMode.Linear),
                                new VectorTrack.Keyframe(0.375F, ModelChannels.posVec(-0F, 0F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.5F, ModelChannels.posVec(-0F, -3F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.625F, ModelChannels.posVec(-0F, 0.25F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.75F, ModelChannels.posVec(-0F, 0F, 0F), VectorTrack.InterpolateMode.CatmullRom)
                        ),
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0F, ModelChannels.degreeVec(-0F, -0F, 0F), VectorTrack.InterpolateMode.Linear),
                                new VectorTrack.Keyframe(0.125F, ModelChannels.degreeVec(10F, -0F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.25F, ModelChannels.degreeVec(20F, -0F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.5F, ModelChannels.degreeVec(7.5F, -0F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.625F, ModelChannels.degreeVec(-5F, -0F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.75F, ModelChannels.degreeVec(-0F, -0F, 0F), VectorTrack.InterpolateMode.CatmullRom)
                        ),
                        VectorTrack.empty()
                ))
                .addAnimation("right_arm", new TransformTrack(
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0F, ModelChannels.posVec(-0F, 0F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.125F, ModelChannels.posVec(0.69182837F, -2.2666187F, -1.8395144F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.25F, ModelChannels.posVec(1.0705845F, -2.7076163F, -3.9775085F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.375F, ModelChannels.posVec(-0F, 1F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.5F, ModelChannels.posVec(-0F, 0F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.625F, ModelChannels.posVec(-0F, 0F, 0F), VectorTrack.InterpolateMode.CatmullRom)
                        ),
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0F, ModelChannels.degreeVec(-36F, -0F, 0F), VectorTrack.InterpolateMode.Linear),
                                new VectorTrack.Keyframe(0.125F, ModelChannels.degreeVec(-32.876F, -2.8943F, -14.7244F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.25F, ModelChannels.degreeVec(-43.7349F, -8.8125F, -11.0381F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.375F, ModelChannels.degreeVec(-32.1764F, 1.315F, 5.2467F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.5F, ModelChannels.degreeVec(-0F, -0F, 7.5F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.625F, ModelChannels.degreeVec(-4.9811F, 0.4352F, 4.9811F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.75F, ModelChannels.degreeVec(-0F, -0F, 0F), VectorTrack.InterpolateMode.CatmullRom)
                        ),
                        VectorTrack.empty()
                ))
                .addAnimation("left_arm", new TransformTrack(
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0F, ModelChannels.posVec(-0F, 0F, 0F), VectorTrack.InterpolateMode.Linear),
                                new VectorTrack.Keyframe(0.125F, ModelChannels.posVec(-0.69182837F, -2.2666187F, -1.8395144F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.25F, ModelChannels.posVec(-1.0705845F, -2.7076163F, -3.9775085F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.375F, ModelChannels.posVec(-0F, 1F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.5F, ModelChannels.posVec(-0F, 0F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.625F, ModelChannels.posVec(-0F, 0F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.75F, ModelChannels.posVec(-0F, 0F, 0F), VectorTrack.InterpolateMode.CatmullRom)
                        ),
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0F, ModelChannels.degreeVec(-36F, -0F, 0F), VectorTrack.InterpolateMode.Linear),
                                new VectorTrack.Keyframe(0.125F, ModelChannels.degreeVec(-32.876F, 2.8943F, 14.7244F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.25F, ModelChannels.degreeVec(-43.7349F, 8.8125F, 11.0381F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.375F, ModelChannels.degreeVec(-32.1764F, -1.315F, -5.2467F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.5F, ModelChannels.degreeVec(-0F, -0F, -7.5F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.625F, ModelChannels.degreeVec(-4.9811F, -0.4352F, -4.9811F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.75F, ModelChannels.degreeVec(-0F, -0F, 0F), VectorTrack.InterpolateMode.CatmullRom)
                        ),
                        VectorTrack.empty()
                ))
                .addAnimation("right_leg", new TransformTrack(
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0F, ModelChannels.posVec(-0F, 0F, 0F), VectorTrack.InterpolateMode.Linear),
                                new VectorTrack.Keyframe(0.25F, ModelChannels.posVec(-1F, 0F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.5F, ModelChannels.posVec(-0.25F, 3F, -1F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.625F, ModelChannels.posVec(-0F, -0.24904868F, 0.021788936F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.75F, ModelChannels.posVec(-0F, 0F, 0F), VectorTrack.InterpolateMode.CatmullRom)
                        ),
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0F, ModelChannels.degreeVec(-81F, 18F, 4.5F), VectorTrack.InterpolateMode.Linear),
                                new VectorTrack.Keyframe(0.125F, ModelChannels.degreeVec(-96.2754F, 24.0961F, 4.2035F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.25F, ModelChannels.degreeVec(-80.3112F, 27.8681F, 6.2609F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.5F, ModelChannels.degreeVec(5F, 5F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.625F, ModelChannels.degreeVec(5F, -0F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.75F, ModelChannels.degreeVec(-0F, -0F, 0F), VectorTrack.InterpolateMode.CatmullRom)
                        ),
                        VectorTrack.empty()
                ))
                .addAnimation("left_leg", new TransformTrack(
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0F, ModelChannels.posVec(-0F, 0F, 0F), VectorTrack.InterpolateMode.Linear),
                                new VectorTrack.Keyframe(0.25F, ModelChannels.posVec(1F, 0F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.5F, ModelChannels.posVec(0.25F, 3F, -1F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.625F, ModelChannels.posVec(-0F, -0.24904868F, 0.021788936F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.75F, ModelChannels.posVec(-0F, 0F, 0F), VectorTrack.InterpolateMode.CatmullRom)
                        ),
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0F, ModelChannels.degreeVec(-81F, -18F, -4.5F), VectorTrack.InterpolateMode.Linear),
                                new VectorTrack.Keyframe(0.125F, ModelChannels.degreeVec(-96.2754F, -24.0961F, -4.2035F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.25F, ModelChannels.degreeVec(-80.3112F, -27.8681F, -6.2609F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.5F, ModelChannels.degreeVec(5F, -5F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.625F, ModelChannels.degreeVec(5F, -0F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.75F, ModelChannels.degreeVec(-0F, -0F, 0F), VectorTrack.InterpolateMode.CatmullRom)
                        ),
                        VectorTrack.empty()
                ))
                .build();
        public static final EntityAnimationDefinition DISMOUNT_BACK_E = EntityAnimationDefinition.Builder.withLength(0.75F)
                .addAnimation("o_transform", new TransformTrack(
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0F, new Vector3f(-0F, 0F, 0F), VectorTrack.InterpolateMode.Linear),
                                new VectorTrack.Keyframe(0.125F, new Vector3f(-0F, 0F, 0F), VectorTrack.InterpolateMode.Linear),
                                new VectorTrack.Keyframe(0.25F, new Vector3f(-0F, 3F, 6F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.5F, new Vector3f(-0F, 1F, 13F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.625F, new Vector3f(-0F, 0F, 16F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.75F, new Vector3f(-0F, 0F, 16F), VectorTrack.InterpolateMode.CatmullRom)
                        ),
                        VectorTrack.empty(),
                        VectorTrack.empty()
                ))
                .addAnimation("mount_motion", new TransformTrack(
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0.375F, new Vector3f(-0F, 0F, 0F), VectorTrack.InterpolateMode.Linear),
                                new VectorTrack.Keyframe(0.5625F, new Vector3f(-0F, -1F, 0F), VectorTrack.InterpolateMode.CatmullRom)
                        ),
                        VectorTrack.empty(),
                        VectorTrack.empty()
                ))
                .build();
        public static final ModelAnimationDefinition DISMOUNT_FORWARD_M = ModelAnimationDefinition.Builder.withLength(0.75001F)
                .addAnimation("head", new TransformTrack(
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0F, ModelChannels.posVec(-0F, 0F, 0F), VectorTrack.InterpolateMode.Linear),
                                new VectorTrack.Keyframe(0.125F, ModelChannels.posVec(-0F, 0F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.25F, ModelChannels.posVec(-0F, -1F, -0.5F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.5F, ModelChannels.posVec(-0F, 0F, 0.5F), VectorTrack.InterpolateMode.CatmullRom)
                        ),
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0F, ModelChannels.degreeVec(-0F, -0F, 0F), VectorTrack.InterpolateMode.Linear),
                                new VectorTrack.Keyframe(0.125F, ModelChannels.degreeVec(2.5F, -0F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.25F, ModelChannels.degreeVec(17.5F, -0F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.5F, ModelChannels.degreeVec(7.5F, -0F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.625F, ModelChannels.degreeVec(-2.5F, -0F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.75F, ModelChannels.degreeVec(-0F, -0F, 0F), VectorTrack.InterpolateMode.CatmullRom)
                        ),
                        VectorTrack.empty()
                ))
                .addAnimation("body", new TransformTrack(
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0F, ModelChannels.posVec(-0F, 0F, 0F), VectorTrack.InterpolateMode.Linear),
                                new VectorTrack.Keyframe(0.375F, ModelChannels.posVec(-0F, 0F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.5F, ModelChannels.posVec(-0F, -3F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.625F, ModelChannels.posVec(-0F, 0.25F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.75F, ModelChannels.posVec(-0F, 0F, 0F), VectorTrack.InterpolateMode.CatmullRom)
                        ),
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0F, ModelChannels.degreeVec(-0F, -0F, 0F), VectorTrack.InterpolateMode.Linear),
                                new VectorTrack.Keyframe(0.125F, ModelChannels.degreeVec(10F, -0F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.25F, ModelChannels.degreeVec(20F, -0F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.5F, ModelChannels.degreeVec(7.5F, -0F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.625F, ModelChannels.degreeVec(5F, -0F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.75F, ModelChannels.degreeVec(-0F, -0F, 0F), VectorTrack.InterpolateMode.CatmullRom)
                        ),
                        VectorTrack.empty()
                ))
                .addAnimation("right_arm", new TransformTrack(
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0F, ModelChannels.posVec(-0F, 0F, 0F), VectorTrack.InterpolateMode.Linear),
                                new VectorTrack.Keyframe(0.125F, ModelChannels.posVec(-0.056344382F, -1.263187F, 0.10827669F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.25F, ModelChannels.posVec(0.09912392F, -3.1580043F, -0.2717364F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.375F, ModelChannels.posVec(-0.08006026F, 0.051342968F, -0.19399315F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.5F, ModelChannels.posVec(-0F, -1F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.625F, ModelChannels.posVec(-0F, 0.25F, 0F), VectorTrack.InterpolateMode.CatmullRom)
                        ),
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0F, ModelChannels.degreeVec(-36F, -0F, 0F), VectorTrack.InterpolateMode.Linear),
                                new VectorTrack.Keyframe(0.125F, ModelChannels.degreeVec(3.7188F, -3.9917F, 0.2628F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.25F, ModelChannels.degreeVec(7.9787F, 6.4132F, -1.0751F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.375F, ModelChannels.degreeVec(12.6988F, -2.5119F, 17.1493F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.5F, ModelChannels.degreeVec(-7.5F, -0F, 7.5F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.625F, ModelChannels.degreeVec(-4.9811F, 0.4352F, 4.9811F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.75F, ModelChannels.degreeVec(-0F, -0F, 0F), VectorTrack.InterpolateMode.CatmullRom)
                        ),
                        VectorTrack.empty()
                ))
                .addAnimation("left_arm", new TransformTrack(
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0F, ModelChannels.posVec(-0F, 0F, 0F), VectorTrack.InterpolateMode.Linear),
                                new VectorTrack.Keyframe(0.125F, ModelChannels.posVec(0.056344382F, -1.263187F, 0.10827669F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.25F, ModelChannels.posVec(-0.09912392F, -3.1580043F, -0.2717364F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.375F, ModelChannels.posVec(0.08006026F, 0.051342968F, 0.056006845F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.5F, ModelChannels.posVec(-0F, -1F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.625F, ModelChannels.posVec(-0F, 0.25F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.75F, ModelChannels.posVec(-0F, 0F, 0F), VectorTrack.InterpolateMode.CatmullRom)
                        ),
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0F, ModelChannels.degreeVec(-36F, -0F, 0F), VectorTrack.InterpolateMode.Linear),
                                new VectorTrack.Keyframe(0.125F, ModelChannels.degreeVec(3.7188F, 3.9917F, -0.2628F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.25F, ModelChannels.degreeVec(7.9787F, -6.4132F, 1.0751F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.375F, ModelChannels.degreeVec(12.6988F, 2.5119F, -17.1493F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.5F, ModelChannels.degreeVec(-0F, -0F, -7.5F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.625F, ModelChannels.degreeVec(-4.9811F, -0.4352F, -4.9811F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.75F, ModelChannels.degreeVec(-0F, -0F, 0F), VectorTrack.InterpolateMode.CatmullRom)
                        ),
                        VectorTrack.empty()
                ))
                .addAnimation("right_leg", new TransformTrack(
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0F, ModelChannels.posVec(-0F, 0F, 0F), VectorTrack.InterpolateMode.Linear),
                                new VectorTrack.Keyframe(0.25F, ModelChannels.posVec(-0F, 0F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.5F, ModelChannels.posVec(-0.25F, 3F, -1F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.625F, ModelChannels.posVec(-0F, -0.24904868F, -0.47821108F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.75F, ModelChannels.posVec(-0F, 0F, 0F), VectorTrack.InterpolateMode.CatmullRom)
                        ),
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0F, ModelChannels.degreeVec(-81F, 18F, 4.5F), VectorTrack.InterpolateMode.Linear),
                                new VectorTrack.Keyframe(0.125F, ModelChannels.degreeVec(-96.2754F, 24.0961F, 4.2035F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.25F, ModelChannels.degreeVec(-80.3112F, 27.8681F, 6.2609F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.375F, ModelChannels.degreeVec(-26.3453F, 16.9823F, 3.259F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.5F, ModelChannels.degreeVec(5F, 5F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.625F, ModelChannels.degreeVec(-0F, -0F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.75F, ModelChannels.degreeVec(-0F, -0F, 0F), VectorTrack.InterpolateMode.CatmullRom)
                        ),
                        VectorTrack.empty()
                ))
                .addAnimation("left_leg", new TransformTrack(
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0F, ModelChannels.posVec(-0F, 0F, 0F), VectorTrack.InterpolateMode.Linear),
                                new VectorTrack.Keyframe(0.25F, ModelChannels.posVec(-0F, 0F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.5F, ModelChannels.posVec(0.25F, 3F, -1F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.625F, ModelChannels.posVec(-0F, -0.24904868F, -0.47821108F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.75F, ModelChannels.posVec(-0F, 0F, 0F), VectorTrack.InterpolateMode.CatmullRom)
                        ),
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0F, ModelChannels.degreeVec(-81F, -18F, -4.5F), VectorTrack.InterpolateMode.Linear),
                                new VectorTrack.Keyframe(0.125F, ModelChannels.degreeVec(-96.2754F, -24.0961F, -4.2035F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.25F, ModelChannels.degreeVec(-80.3112F, -27.8681F, -6.2609F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.375F, ModelChannels.degreeVec(-26.3453F, -16.9823F, -3.259F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.5F, ModelChannels.degreeVec(5F, -5F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.625F, ModelChannels.degreeVec(-0F, -0F, 0F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.75F, ModelChannels.degreeVec(-0F, -0F, 0F), VectorTrack.InterpolateMode.CatmullRom)
                        ),
                        VectorTrack.empty()
                ))
                .build();
        public static final EntityAnimationDefinition DISMOUNT_FORWARD_E = EntityAnimationDefinition.Builder.withLength(0.75001F)
                .addAnimation("o_transform", new TransformTrack(
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0F, new Vector3f(-0F, 0F, 0F), VectorTrack.InterpolateMode.Linear),
                                new VectorTrack.Keyframe(0.125F, new Vector3f(-0F, 0F, 0F), VectorTrack.InterpolateMode.Linear),
                                new VectorTrack.Keyframe(0.25F, new Vector3f(-0F, 3F, -6F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.375F, new Vector3f(-0F, 0.97F, -9.69F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.5F, new Vector3f(-0F, 0.5F, -13F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.625F, new Vector3f(-0F, 0F, -16F), VectorTrack.InterpolateMode.CatmullRom),
                                new VectorTrack.Keyframe(0.75F, new Vector3f(-0F, 0F, -16F), VectorTrack.InterpolateMode.CatmullRom)
                        ),
                        VectorTrack.empty(),
                        VectorTrack.empty()
                ))
                .addAnimation("mount_motion", new TransformTrack(
                        VectorTrack.of(
                                new VectorTrack.Keyframe(0.375F, new Vector3f(-0F, 0F, 0F), VectorTrack.InterpolateMode.Linear),
                                new VectorTrack.Keyframe(0.5F, new Vector3f(-0F, -1F, 0F), VectorTrack.InterpolateMode.CatmullRom)
                        ),
                        VectorTrack.empty(),
                        VectorTrack.empty()
                ))
                .build();
    }
}
