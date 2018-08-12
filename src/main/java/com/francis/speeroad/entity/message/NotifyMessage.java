package com.francis.speeroad.entity.message;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.annotation.JSONField;
import com.francis.speeroad.entity.type.TargetType;

/**
 * 聊天消息
 * @author hzzhugequn
 * @date 2018/8/12
 * @since JDK 1.8
 */
public class NotifyMessage {
    /**
     * 聊天类型 users， groupchat
     */
    @JSONField(name = "target_type")
    private TargetType targetType;

    /**
     * 发送消息的目标
     */
    @JSONField(name = "target")
    private List<String> targetIds;

    /**
     * 消息主题
     */
    @JSONField(name = "msg")
    private Notify notify;

    /**
     * 消息来源
     */
    private String from;

    /**
     * 扩展属性
     */
    private Map<String, String> ext;

    public NotifyMessage() {
    }

    public NotifyMessage(TargetType targetType, List<String> targetIds, Notify notify, String from) {
        this.targetType = targetType;
        this.targetIds = targetIds;
        this.notify = notify;
        this.from = from;
    }

    /**
     * 加入一个发送对象
     * @param target
     */
    public void pushTarget(String target){
        if (this.targetIds == null){
            this.targetIds = new ArrayList<>();
        }
        this.targetIds.add(target);
    }

    /**
     * 加入一个扩展信息
     * @param key
     * @param value
     */
    public void pushExt(String key, String value) {
        if (this.ext == null) {
            this.ext = new HashMap<String, String>();
        }
        this.ext.put(key, value);
    }

    public TargetType getTargetType() {
        return targetType;
    }

    public void setTargetType(TargetType targetType) {
        this.targetType = targetType;
    }

    public List<String> getTargetIds() {
        return targetIds;
    }

    public void setTargetIds(List<String> targetIds) {
        this.targetIds = targetIds;
    }

    public Notify getNotify() {
        return notify;
    }

    public void setNotify(Notify notify) {
        this.notify = notify;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Map<String, String> getExt() {
        return ext;
    }

    public void setExt(Map<String, String> ext) {
        this.ext = ext;
    }

    @Override
    public String toString() {
        return "NotifyMessage{" +
                       "targetType=" + targetType +
                       ", targetIds=" + targetIds +
                       ", notify=" + notify +
                       ", from='" + from + '\'' +
                       ", ext=" + ext +
                       '}';
    }
}
