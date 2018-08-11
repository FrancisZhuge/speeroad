package com.francis.speeroad.service;

import com.francis.speeroad.entity.EMUser;

/**
 * @author hzzhugequn
 * @date 2018/8/5
 * @since JDK 1.8
 */
public interface EMUserService {

    /**
     * 新增用户
     *
     * @param user 用户
     */
    void addUser(EMUser user);

    /**
     * 获取用户
     *
     * @param username 用户名
     * @return 用户
     */
    EMUser getUser(String username);
}
