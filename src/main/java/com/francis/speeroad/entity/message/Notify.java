package com.francis.speeroad.entity.message;

import com.alibaba.fastjson.annotation.JSONField;
import com.francis.speeroad.entity.type.MessageType;

/**
 * @author hzzhugequn
 * @date 2018/8/12
 * @since JDK 1.8
 */
public abstract class Notify {
    @JSONField(name = "type")
    private MessageType messageType;

    public Notify(MessageType messageType) {
        this.messageType = messageType;
    }

    public MessageType getMessageType() {
        return messageType;
    }
}
