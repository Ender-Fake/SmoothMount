package com.enderium.smoothmount.client.model;

import net.minecraft.client.model.geom.ModelPart;

import java.util.ArrayList;
import java.util.List;

public class ModelPartWrapper {

    private final ModelPart part;

    public final List<ModelPartWrapper> children=new ArrayList<>();

    public ModelPartWrapper(ModelPart part){
        this.part=part;
    }


    public float x(){
        return part.x;
    }

    public float y(){
        return part.y;
    }

    public float z(){
        return part.z;
    }

    public float xRot(){
        return part.xRot;
    }

    public float yRot(){
        return part.yRot;
    }

    public float zRot(){
        return part.zRot;
    }

    public void x(float x){
        float v = x - part.x;
        part.x=x;
        if (v==0)return;
        for (ModelPartWrapper child : children) child.x(child.x() + v);

    }

    public void y(float y){
        float v = y - part.y;
        part.y=y;
        if (v==0)return;
        for (ModelPartWrapper child : children) child.y(child.y() + v);

    }

    public void z(float z){
        float v = z - part.z;
        part.z=z;
        if (v==0)return;
        for (ModelPartWrapper child : children) child.z(child.z() + v);

    }


    public void xRot(float x){
        float v = x - part.xRot;
        part.xRot=x;
        if (v==0)return;
        for (ModelPartWrapper child : children) child.xRot(child.xRot() + v);

    }

    public void yRot(float y){
        float v = y - part.yRot;
        part.yRot=y;
        if (v==0)return;
        for (ModelPartWrapper child : children) child.yRot(child.yRot() + v);

    }

    public void zRot(float z){
        float v = z - part.zRot;
        part.zRot=z;
        if (v==0)return;
        for (ModelPartWrapper child : children) child.zRot(child.zRot() + v);

    }


    public ModelPart part() {
        return part;
    }


    /*public List<ModelPartWrapper> children() {
        return children;
    }*/



}
