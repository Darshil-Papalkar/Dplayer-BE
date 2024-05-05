package com.dplay.dplayer.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;

@Slf4j
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

    public static <T> T capitalizeAllStrings(T entity) {
        try {
            Class<?> clazz = entity.getClass();
            Field[] fields = clazz.getDeclaredFields();

            for (Field field : fields) {
                if (field.getType() == String.class) {
                    field.setAccessible(true);
                    String value = (String) field.get(entity);
                    if (value != null) {
                        field.set(entity, StringUtils.capitalize(value));
                    }
                }
            }
        } catch (IllegalAccessException | IllegalArgumentException e) {
            // Handle exceptions as needed
            log.info(e.getMessage());
            e.printStackTrace();
        }
        return entity;
    }
}
