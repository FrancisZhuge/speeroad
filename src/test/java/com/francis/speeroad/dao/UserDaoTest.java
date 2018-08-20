package com.francis.speeroad.dao;

import com.francis.speeroad.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author francis
 * @className
 * @date 2018/8/13
 * @see
 * @since JDK 1.8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {
    @Autowired
    UserDao userDao;

    @Test
    public void insert(){
        User user = new User();
        user.setUsername("francis1");
        user.setPassword("1234");
        user.setEasePassword("1234");
        user.setSalt("1234");
        user.setUuid("1234");
        user.setCreateTime(111L);
        user.setModifyTime(111L);
        userDao.addUser(user);
        System.out.println(user);
    }

    @Test
    public void getById(){
        User user = userDao.getUserById(1L);
        System.out.println(user);
    }

    @Test
    public void getByUsername(){
        User user = userDao.getUserByUsername("francis");
        System.out.println(user);
    }
}
