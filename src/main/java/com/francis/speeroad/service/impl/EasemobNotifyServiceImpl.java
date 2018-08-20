package com.francis.speeroad.service.impl;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.francis.speeroad.conf.HttpConfig;
import com.francis.speeroad.entity.message.NotifyMessage;
import com.francis.speeroad.exception.BaseException;
import com.francis.speeroad.service.EasemobNotifyService;
import com.francis.speeroad.service.HttpService;
import com.francis.speeroad.token.TokenService;

import java.util.ArrayList;
import java.util.List;

/**
 * 聊天记录
 *
 * @author hzzhugequn
 * @date 2018/8/12
 * @since JDK 1.8
 */
@Service
public class EasemobNotifyServiceImpl implements EasemobNotifyService {

    @Autowired
    TokenService tokenService;

    @Autowired
    HttpConfig httpConfig;

    @Autowired
    HttpService httpService;

    @Override
    public JSONObject sendNotify(NotifyMessage message) throws BaseException {
        String url = httpConfig.getSendMessageUrl();
        String value = "Bearer " + tokenService.getToken().getToken();
        Header header = new BasicHeader("Authorization", value);
        List<Header> headers = new ArrayList<>();
        headers.add(header);
        String params = JSON.toJSONString(message);
        String returnValue = httpService.post(url, headers, params);
        System.out.println(returnValue);
        return JSONObject.parseObject(returnValue).getJSONObject("data");
    }

    @Override
    public JSONObject getMessages(String time) throws BaseException {
        String url = httpConfig.getMessagesUrl(time);
        String value = "Bearer " + tokenService.getToken().getToken();
        Header header = new BasicHeader("Authorization", value);
        List<Header> headers = new ArrayList<>();
        headers.add(header);
        String returnValue = httpService.get(url, headers);
        System.out.println(returnValue);
        return null;
    }
}
