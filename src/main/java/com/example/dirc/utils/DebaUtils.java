package com.example.dirc.utils;

public class DebaUtils {

    public static String getHost(String deba) {
        return deba.substring(deba.indexOf("@") + 1);
    }

}
