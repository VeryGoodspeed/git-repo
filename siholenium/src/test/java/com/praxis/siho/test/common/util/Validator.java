package com.praxis.siho.test.common.util;

/**
 * Created by administrativo on 26/06/15.
 */
public class Validator {
    public static boolean isNaN(String n){
        try{
            new Integer(n);
            return Boolean.TRUE;
        }catch (NumberFormatException nfe){
            return Boolean.FALSE;
        }
    }
}
