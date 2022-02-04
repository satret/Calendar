package com.company;

public class ImbaMethods {
    public static int convertstringtoint(String s, int a){
        try
        {
            // именно здесь String преобразуется в int
            a = Integer.parseInt(s.trim());
        }
        catch (NumberFormatException nfe)
        {
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }
        return a;
    }
}
