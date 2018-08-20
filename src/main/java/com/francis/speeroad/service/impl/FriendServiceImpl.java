package com.francis.speeroad.service.impl;

import com.francis.speeroad.service.CacheService;
import com.francis.speeroad.service.FriendService;
import com.francis.speeroad.util.CacheUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author francis
 * @className
 * @date 2018/8/13
 * @see
 * @since JDK 1.8
 */
@Service
public class FriendServiceImpl implements FriendService {

    @Autowired
    CacheService cacheService;

    @Override
    public void addFriend(String username, String friendUsername) {
        String key = CacheUtil.getFriendKey(username);
        cacheService.sadd(key, friendUsername);
    }

    @Override
    public Set<String> getFriend(String username) {
        String key = CacheUtil.getFriendKey(username);
        return cacheService.sget(key);
    }
}
