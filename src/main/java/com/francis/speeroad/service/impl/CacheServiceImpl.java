package com.francis.speeroad.service.impl;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.util.Pool;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.francis.speeroad.conf.CacheConfig;
import com.francis.speeroad.exception.CacheNotExistException;
import com.francis.speeroad.service.CacheService;

import java.util.Set;

/**
 * 缓存具体服务类
 *
 * @author hzzhugequn
 * @date 2018/8/4
 * @since JDK 1.8
 */
@Service
public class CacheServiceImpl implements CacheService {

    private Pool<Jedis> jedisPool;

    @Autowired
    private CacheConfig cacheConfig;

    @PostConstruct
    public void init() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(cacheConfig.getTotal());
        jedisPoolConfig.setMaxIdle(cacheConfig.getIdle());
        jedisPoolConfig.setMaxWaitMillis(cacheConfig.getWaitTime());
        jedisPoolConfig.setTestOnBorrow(cacheConfig.isTestOnBorrow());
        jedisPoolConfig.setTestOnReturn(cacheConfig.isTestOnReturn());

        jedisPool = new JedisPool(jedisPoolConfig, cacheConfig.getHost(), cacheConfig.getPort(), cacheConfig.getTimeout(), cacheConfig.getPassword());
    }

    @Override
    public String get(String key) throws CacheNotExistException {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String value = jedis.get(key);
            if (StringUtils.isBlank(value)) {
                throw new CacheNotExistException(key);
            } else {
                return value;
            }
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    @Override
    public void put(String key, String value, int expire) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.setex(key, expire, value);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    @Override
    public void delete(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.del(key);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }


    @Override
    public void sadd(String key, String value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.sadd(key, value);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    @Override
    public Set<String> sget(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.sinter(key);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    @Override
    public void zadd(String key, long score, String value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.zadd(key, score, value);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    @Override
    public Set<String> zget(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.zrange(key, 0, -1);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }
}
