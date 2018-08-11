package com.francis.speeroad.exception;

/**
 * 缓存异常类基类
 * @author hzzhugequn
 * @date 2018/8/4
 * @since JDK 1.8
 */
public class CacheNotExistException extends BaseException {

    public CacheNotExistException() {
        super("Cache not exist");
    }

    public CacheNotExistException(String key) {
        super("Cache not exist. key= " + key);
    }
}
