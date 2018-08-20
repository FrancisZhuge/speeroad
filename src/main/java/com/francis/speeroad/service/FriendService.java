package com.francis.speeroad.service;

import java.util.Set;

/**
 * @author francis
 * @className
 * @date 2018/8/13
 * @see
 * @since JDK 1.8
 */
public interface FriendService {

    void addFriend(String username, String friendUsername);

    Set<String> getFriend(String username);
}
