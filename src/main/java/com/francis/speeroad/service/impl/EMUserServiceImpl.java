package com.francis.speeroad.service.impl;

import com.francis.speeroad.dao.UserDao;
import com.francis.speeroad.entity.EaseMobUser;
import com.francis.speeroad.service.EMUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EMUserServiceImpl implements EMUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void addUser(EaseMobUser user) {

    }

    @Override
    public EaseMobUser getUser(String username) {
        return userDao.getUserByUsername(username);
    }
}
