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
    private final static String SEPARATOR = "#";
    private final static String TOKEN = "TOKEN";
    private final static String FRIEND_BUSINESS = "FRIEND";
    private final static String MESSAGE_BUSINESS = "MESSAGE";

    /**
     * 获取token的key
     *
     * @return 生成的key
     */
    public static String getTokenKey() {
        return PREFIX + SEPARATOR + TOKEN;
    }

    /**
     * 获取朋友的key
     *
     * @param username 用户名
     * @return 生成的key
     */
    public static String getFriendKey(String username) {
        return PREFIX + SEPARATOR + FRIEND_BUSINESS + SEPARATOR + username;
    }

    /**
     * 获取消息的key
     *
     * @param username       用户名
     * @param friendUsername 发消息对象的用户名
     * @return
     */
    public static String getMEssageKey(String username, String friendUsername) {
        return PREFIX + SEPARATOR + MESSAGE_BUSINESS + SEPARATOR + username + SEPARATOR + friendUsername;
    }
}
