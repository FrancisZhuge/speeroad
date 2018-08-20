package com.francis.speeroad.dao;

import com.francis.speeroad.entity.Token;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author francis
 * @className
 * @date 2018/8/13
 * @see
 * @since JDK 1.8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TokenDaoTest {
    @Autowired
    TokenDao tokenDao;

    @Test
    public void addToken(){
        Token token = new Token();
        token.setUserId(1L);
        token.setExpired(new Date());
        token.setToken("1111111");
        token.setStatus(true);
        tokenDao.addToken(token);
        System.out.println(token);
    }

    @Test
    public void getToken(){
        Token token = tokenDao.getTokenByToken("1111111");
        System.out.println(token);
    }

    @Test
    public void updateToken(){
        Token token = tokenDao.getTokenByToken("1111111");
        System.out.println(token);
        tokenDao.updateStatus("1111111", false);
        token = tokenDao.getTokenByToken("1111111");
        System.out.println(token);
    }
}
