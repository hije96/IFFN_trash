package com.example.juntae.diffuser;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by juntae on 2017-01-12.
 */

public class DataModel {
    DataModel(){

    }
    DataModel(int x, int y, int z, int l){
        this.x = x;
        this.y = y;
        this.z = z;
        this.l = l;
    }
    private int x;
    private int y;
    private int z;
    private int l;

    public int getX ()
    {
        return x;
    }

    public void setX (int x)
    {
        this.x = x;
    }

    public int getY ()
    {
        return y;
    }

    public void setY (int y)
    {
        this.y = y;
    }

    public int getZ ()
    {
        return z;
    }

    public void setZ (int z)
    {
        this.z = z;
    }

    public int getl ()
    {
        return l;
    }

    public void setl (int l)
    {
        this.l = l;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [x = "+x+", y = "+y+", z = "+z+", l = "+l+"]";
    }
}



