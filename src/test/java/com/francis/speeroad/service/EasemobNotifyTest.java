package com.francis.speeroad.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSONObject;
import com.francis.speeroad.entity.message.NotifyMessage;
import com.francis.speeroad.entity.message.Txt;
import com.francis.speeroad.entity.type.TargetType;
import com.francis.speeroad.exception.BaseException;

/**
 * @author hzzhugequn
 * @date 2018/8/12
 * @since JDK 1.8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EasemobNotifyTest {

    @Autowired
    EasemobNotifyService easemobNotifyService;

    @Test
    public void sendMessage() throws BaseException {
        Txt text = new Txt("hello");
        NotifyMessage message = new NotifyMessage();
        message.setTargetType(TargetType.users);
        message.setFrom("fuck1");
        message.setNotify(text);
        message.pushTarget("fuck2");
        message.pushTarget("fuck3");
        message.pushExt("a","a");
        JSONObject jsonObject = easemobNotifyService.sendNotify(message);
        System.out.println(jsonObject.toJSONString());
    }

    @Test
    public void getMessage() throws BaseException{
        String time = "2018081214";
        JSONObject messages = easemobNotifyService.getMessages(time);
    }
}
