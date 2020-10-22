package com.company;

import java.util.ArrayList;

public class FourthVar implements Resultat  {
    private  String [] x;

    public ArrayList<Integer> getResultat()
    {
        int numberOfEvenNumbers = 0;
        int numberOfOddNumbers = 0;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();


        for(int i = 0; i < x.length; i++)
        {
            if (Integer.parseInt(x[i]) % 2 == 0)
            {

                ++numberOfEvenNumbers;
            } else
            {
                ++numberOfOddNumbers;
            }

        }

        arrayList.add(numberOfEvenNumbers);
        arrayList.add(numberOfOddNumbers);
        return arrayList;
    }
    public FourthVar(String s)
    {
        String[] s1 = s.split(" ");
        x = new String[s1.length - 1];
        for (int i = 1; i < s1.length; i++)
        {
            x[i - 1] = s1[i].replace(",", "").replace(" ", "");
        }

    }
    public FourthVar(String[] a)
    {
        x=a;
    }

    public FourthVar(ArrayList<String> L)
    {
        x = new String[L.size()];
        L.toArray(x);
    }

}