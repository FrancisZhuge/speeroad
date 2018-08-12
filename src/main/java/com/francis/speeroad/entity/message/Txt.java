package com.francis.speeroad.entity.message;

import com.alibaba.fastjson.annotation.JSONField;
import com.francis.speeroad.entity.type.MessageType;

/**
 * @author hzzhugequn
 * @date 2018/8/12
 * @since JDK 1.8
 */
public class Txt extends Notify{
    @JSONField(name = "msg")
    private String content;

    public Txt(String content) {
        super(MessageType.txt);
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Text{" +
                       "content='" + content + '\'' +
                       '}';
    }
}
