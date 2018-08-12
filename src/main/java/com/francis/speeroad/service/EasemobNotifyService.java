package com.francis.speeroad.service;

import com.alibaba.fastjson.JSONObject;
import com.francis.speeroad.entity.message.NotifyMessage;
import com.francis.speeroad.exception.BaseException;

/**
 * 消息服务接口
 *
 * @author hzzhugequn
 * @date 2018/8/12
 * @since JDK 1.8
 */
public interface EasemobNotifyService {

    /**
     * 发送消息
     *
     * @param message 消息对象
     * @return { "stliu1": "success", "jma3": "success", "stliu": "success", "jma4": "success" }
     * @throws BaseException
     */
    JSONObject sendNotify(NotifyMessage message) throws BaseException;

    /**
     * 获取历史消息
     * @param time
     * @return
     * @throws BaseException
     */
    JSONObject getMessages(String time) throws BaseException;

}
