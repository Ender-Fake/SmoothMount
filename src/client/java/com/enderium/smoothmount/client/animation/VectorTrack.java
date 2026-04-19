package com.enderium.smoothmount.client.animation;

import net.minecraft.util.Mth;
import org.joml.Vector3f;

public class VectorTrack implements IndexProvider {
    public static final VectorTrack EMPTY = new EmptyTrack();

    public float[] timestamps;
    //public float[] keyframes;
    public Vector3f[] keyframes;
    public InterpolateMode[] modes;
    public int length;

    public static VectorTrack of(float[] timestamps, Vector3f[] keyframes, InterpolateMode[] modes) {
        if (timestamps.length != keyframes.length || timestamps.length != modes.length)
            throw new IllegalArgumentException("Arrays must have the same length");
        return new VectorTrack(timestamps, keyframes, modes);
    }

    public static VectorTrack of(Keyframe... frames) {
        int length = frames.length;
        float[] timestamps = new float[length];
        Vector3f[] keyframes = new Vector3f[length];
        InterpolateMode[] modes = new InterpolateMode[length];
        for (int i = 0; i < frames.length; i++) {
            Keyframe keyframe = frames[i];
            timestamps[i] = keyframe.time;
            keyframes[i] = keyframe.value;
            modes[i] = keyframe.mode;
        }
        return of(timestamps, keyframes, modes);
    }

    protected VectorTrack(float[] timestamps, Vector3f[] keyframes, InterpolateMode[] modes) {
        this.timestamps = timestamps;
        this.modes = modes;
        this.length=modes.length;
        this.keyframes=keyframes;
        /*this.keyframes=new float[keyframes.length*3];
        for (int i = 0; i < keyframes.length; i++) {
            int index =i*3;
            Vector3f keyframe = keyframes[i];
            this.keyframes[index]=keyframe.x;
            this.keyframes[index+1]=keyframe.y;
            this.keyframes[index+2]=keyframe.z;
        }*/


    }

    protected VectorTrack() {

    }

    public void evaluate(Vector3f out, int last, float time) {
        int nextIndex = last + 1;

        if (nextIndex >= length) {
            //int i = last * 3;
            //out.set(keyframes[i],keyframes[i+1],keyframes[i+2]);
            out.set(keyframes[last]);
            return;
        }

        float startTime = timestamps[last];
        float endTime = timestamps[nextIndex];

        float duration = endTime - startTime;
        float alpha = (duration == 0) ? 0 : (time - startTime) / duration;

        if (alpha < 0) alpha = 0;
        if (alpha > 1) alpha = 1;

        modes[last].interpolate(out, alpha, keyframes, last, nextIndex);
        //modes[last].interpolate(out, alpha, keyframes, length, last, nextIndex);
    }

    public VectorChannel createChannel() {
        return new VectorChannel(this);
    }

    public static VectorTrack empty() {
        return EMPTY;
    }

    @Override
    public final int getIndexCount() {
        return 1;
    }


    /*public enum InterpolateMode {
        Linear {
            @Override
            public void interpolate(Vector3f self, float alpha, final float[] keyframes, final int length, int prev, int next) {
                prev*=3;
                next*=3;
                self.set(
                        org.joml.Math.fma(keyframes[next] - keyframes[prev], alpha, keyframes[prev]),
                        org.joml.Math.fma(keyframes[next+1] - keyframes[prev+1], alpha, keyframes[prev+1]),
                        org.joml.Math.fma(keyframes[next+2] - keyframes[prev+2], alpha, keyframes[prev+2])
                );

            }

        },
        CatmullRom {
            @Override
            public void interpolate(Vector3f self, float alpha, final float[] keyframes, final int length, int prev, int next) {
                int f=Math.max(0, prev - 1)*3;
                int l=Math.min(length - 1, next + 1)*3;
                prev*=3;
                next*=3;
                self.set(
                        Mth.catmullrom(alpha, keyframes[f], keyframes[prev], keyframes[next], keyframes[l]),
                        Mth.catmullrom(alpha, keyframes[f+1], keyframes[prev+1], keyframes[next+1], keyframes[l+1]),
                        Mth.catmullrom(alpha, keyframes[f+2], keyframes[prev+2], keyframes[next+2], keyframes[l+2])
                );
            }
        },
        Step {
            @Override
            public void interpolate(Vector3f self, float alpha, final float[] keyframes, final int length, int prev, final int next) {
                prev*=3;
                self.set(keyframes[prev],keyframes[prev+1],keyframes[prev+2]);
            }

        };

        public abstract void interpolate(Vector3f self, float alpha, final float[] keyframes, final int length, final int prev, final int next);

    }*/

    public enum InterpolateMode {
        Linear {

            @Override
            public void interpolate(Vector3f self, float alpha, final Vector3f[] keyframes, final int prev, final int next) {
                keyframes[prev].lerp(keyframes[next], alpha, self);
            }

        },
        CatmullRom {
            @Override
            public void interpolate(Vector3f self, float alpha, final Vector3f[] keyframes, final int prev, final int next) {
                Vector3f p0 = keyframes[Math.max(0, prev - 1)];
                Vector3f p1 = keyframes[prev];
                Vector3f p2 = keyframes[next];
                Vector3f p3 = keyframes[Math.min(keyframes.length - 1, next + 1)];
                self.set(Mth.catmullrom(alpha, p0.x(), p1.x(), p2.x(), p3.x()), Mth.catmullrom(alpha, p0.y(), p1.y(), p2.y(), p3.y()), Mth.catmullrom(alpha, p0.z(), p1.z(), p2.z(), p3.z()));
            }
        },
        Step {

            @Override
            public void interpolate(Vector3f self, float alpha, final Vector3f[] keyframes, final int prev, final int next) {
                self.set(keyframes[prev]);
            }
        };

        public abstract void interpolate(Vector3f self, float alpha, final Vector3f[] keyframes, final int prev, final int next);

    }

    public record Keyframe(float time, Vector3f value, InterpolateMode mode) {

    }

    private static class EmptyTrack extends VectorTrack {
        public EmptyTrack() {
            super();
        }

        @Override
        public void evaluate(Vector3f out, int last, float time) {
            //out.zero();
        }

        @Override
        public VectorChannel createChannel() {
            return VectorChannel.EMPTY;
        }
    }

}
