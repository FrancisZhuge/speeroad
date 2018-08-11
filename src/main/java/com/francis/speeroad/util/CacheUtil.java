package com.francis.speeroad.util;

/**
 * 缓存key生成工具类
 *
 * @author hzzhugequn
 * @date 2018/8/4
 * @since JDK 1.8
 */
public class CacheUtil {

    private final static String PREFIX = "EASE-MOB";
    private final static String SEPARATOR = "-";
    private final static String TOKEN = "TOKEN";

    /**
     * 获取token的key
     *
     * @return 生成的key
     */
    public static String getTokenKey() {
        return PREFIX + SEPARATOR + TOKEN;
    }
}
