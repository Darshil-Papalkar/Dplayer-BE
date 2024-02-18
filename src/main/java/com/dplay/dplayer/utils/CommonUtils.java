package com.dplay.dplayer.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CommonUtils {
    private CommonUtils() {
    }

    private static final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public static String hashPassword(String plainText) {
        return bCryptPasswordEncoder.encode(plainText);
    }

    public static Boolean validatePassword(String encode, String plainText) {
        return bCryptPasswordEncoder.matches(plainText, encode);
    }
}
