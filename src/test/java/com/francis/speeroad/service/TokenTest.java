package com.francis.speeroad.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.francis.speeroad.token.EMToken;
import com.francis.speeroad.exception.http.HttpException;
import com.francis.speeroad.token.TokenService;

/**
 * @author hzzhugequn
 * @date 2018/8/4
 * @since JDK 1.8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TokenTest {

    @Autowired
    private TokenService tokenService;

    @Test
    public void contextLoads() throws HttpException {
        EMToken token = tokenService.getToken();
        System.out.println(token);
    }
}
