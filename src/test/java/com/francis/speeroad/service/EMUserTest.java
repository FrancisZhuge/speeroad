package com.francis.speeroad.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.francis.speeroad.entity.EaseMobUser;
import com.francis.speeroad.exception.BaseException;

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
    EasemobUserService easemobService;
    @Test
    public void register() throws BaseException {
        EaseMobUser register = easemobService.registerSingle("fuck4", "123456", "");
        System.out.println(register);
    }

    @Test
    public void get() throws BaseException{
        EaseMobUser fuck = easemobService.getSingle("fuck1");
        System.out.println(fuck);
    }

    @Test
    public void del() throws BaseException{
        EaseMobUser fuck = easemobService.delSingle("fuck");
        System.out.println(fuck);
    }

    @Test
    public void reset() throws BaseException{
        EaseMobUser fuck = easemobService.resetSingle("fuck2","1234567");
    }

    @Test
    public void resetNickName() throws BaseException{
        EaseMobUser fuck = easemobService.resetNickname("fuck2","张国荣1");
    }

    @Test
    public void addFriend() throws BaseException{
        EaseMobUser user = easemobService.addFriend("fuck1", "fuck3");
        System.out.println(user);
    }

    @Test
    public void delFriend() throws BaseException{
        EaseMobUser user = easemobService.delFriend("fuck1", "fuck2");
        System.out.println(user);
        EaseMobUser fuck1 = easemobService.getSingle("fuck1");
        System.out.println(fuck1);
        EaseMobUser fuck2 = easemobService.getSingle("fuck2");
        System.out.println(fuck2);
    }

    @Test
    public void getFriend() throws BaseException{
        List<String> fuck1 = easemobService.getFriend("fuck1");
        System.out.println(fuck1);
    }

    @Test
    public void getStatus() throws BaseException{
        Boolean fuck1 = easemobService.getStatus("fuck1");
        System.out.println(fuck1);
    }
    @Test
    public void getCounts() throws BaseException{
        Long fuck1 = easemobService.getOfflineCounts("fuck1");
        System.out.println(fuck1);
    }

    @Test
    public void deactivate() throws BaseException{
        EaseMobUser fuck1 = easemobService.deactivate("fuck1");
        System.out.println(fuck1);
    }

    @Test
    public void activate() throws BaseException{
        EaseMobUser fuck1 = easemobService.activate("fuck1");
        System.out.println(fuck1);
    }

    @Test
    public void disconnect() throws BaseException{
        Boolean fuck1 = easemobService.disConnect("fuck1");
        System.out.println(fuck1);
    }
}
