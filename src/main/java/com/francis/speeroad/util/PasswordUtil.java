package com.francis.speeroad.util;

import java.util.UUID;

/**
 * @author hzzhugequn
 * @date 2018/8/5
 * @since JDK 1.8
 */
public class PasswordUtil {
    public static String genPassword(){
        String uuid = UUID.randomUUID().toString().replaceAll("-", "") + System.currentTimeMillis();
        return uuid;
    }
}
