package com.francis.speeroad.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.francis.speeroad.dao.EMUserDao;
import com.francis.speeroad.entity.EMUser;
import com.francis.speeroad.service.EMUserService;

/**
 * @author hzzhugequn
 * @date 2018/8/5
 * @since JDK 1.8
 */
@Service
public class EMUserServiceImpl implements EMUserService {

    @Autowired
    private EMUserDao userDao;

    @Override
    public void addUser(EMUser user) {
        userDao.addUser(user);
    }

    @Override
    public EMUser getUser(String username) {
        return userDao.getUser(username);
    }
}
