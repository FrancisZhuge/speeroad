package com.francis.speeroad.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.francis.speeroad.entity.EMToken;
import com.francis.speeroad.entity.EMUser;
import com.francis.speeroad.exception.BaseException;
import com.francis.speeroad.exception.http.HttpException;

import java.util.List;

/**
 * @author hzzhugequn
 * @date 2018/8/5
 * @since JDK 1.8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EMUserTest {

    @Autowired
    EasemobService easemobService;
    @Test
    public void register() throws BaseException {
        EMUser register = easemobService.registerSingle("fuck3", "123456", "");
        System.out.println(register);
    }

    @Test
    public void get() throws BaseException{
        EMUser fuck = easemobService.getSingle("fuck1");
        System.out.println(fuck);
    }

    @Test
    public void del() throws BaseException{
        EMUser fuck = easemobService.delSingle("fuck");
        System.out.println(fuck);
    }

    @Test
    public void reset() throws BaseException{
        EMUser fuck = easemobService.resetSingle("fuck2","1234567");
    }

    @Test
    public void resetNickName() throws BaseException{
        EMUser fuck = easemobService.resetNickname("fuck2","张国荣1");
    }

    @Test
    public void addFriend() throws BaseException{
        EMUser user = easemobService.addFriend("fuck1", "fuck3");
        System.out.println(user);
    }

    @Test
    public void delFriend() throws BaseException{
        EMUser user = easemobService.delFriend("fuck1", "fuck2");
        System.out.println(user);
        EMUser fuck1 = easemobService.getSingle("fuck1");
        System.out.println(fuck1);
        EMUser fuck2 = easemobService.getSingle("fuck2");
        System.out.println(fuck2);
    }

    @Test
    public void getFriend() throws BaseException{
        List<String> fuck1 = easemobService.getFriend("fuck1");
        System.out.println(fuck1);
    }


}
