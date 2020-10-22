package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class Object implements Serializable {
    private String []x;
    private ArrayList<String> sl;
    private String message;
    private String type;
    public Object(String m)
    {
        message = m;
    }
    public Object(ArrayList<String> a , String m, String t)
    {
        x = new String[a.size()];
        for (int i = 0; i < a.size(); i++)
        {
            x[i] = a.get(i);
        }
        sl = a;
        message = m;
        type = t;
    }
    public Object(String []a, String m){
        x=a; message = m;
    }


    public String[] getArray()
    {

        return x;
    }
    public String getMess(){
        return message;
    }
    public String getSt() {
        return message;
    }
    public ArrayList<String> getSl() {
        return sl;
    }

    public String getType()
    {
        return type;
    }

}

