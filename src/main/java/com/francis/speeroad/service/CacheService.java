package com.francis.speeroad.service;

import com.francis.speeroad.exception.CacheNotExistException;

import java.util.Set;

/**
 * 缓存服务类
 *
 * @author hzzhugequn
 * @date 2018/8/4
 * @since JDK 1.8
 */
public interface CacheService {
    /**
     * 查找缓存中的对象
     *
     * @param key 键
     * @return
     */
    String get(String key) throws CacheNotExistException;

    /**
     * 缓存（带时间）
     *
     * @param key    键
     * @param value  值
     * @param expire 时间（单位：秒）
     */
    void put(String key, String value, int expire);

    /**
     * 移除缓存对象
     *
     * @param key
     * @return
     */
    void delete(String key);

    void sadd(String key, String value);

    Set<String> sget(String key);

    void zadd(String key, long score, String value);

    Set<String> zget(String key);
}
