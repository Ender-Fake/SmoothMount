package com.enderium.smoothmount.client.animation;

import java.util.Arrays;

public class IndexInstance {

    public final int length;
    public final int[] index;

    public IndexInstance(int length) {
        this.length = length;
        this.index = new int[length];
    }

    public void clearRange(int start, int length){
        Arrays.fill(index,start,start+length,0);
    }

    public void clear(int start, int end){
        Arrays.fill(index,start,end,0);
    }

}
