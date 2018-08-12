package com.francis.speeroad.entity;

import com.alibaba.fastjson.annotation.JSONCreator;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * name-value
 *
 * @author hzzhugequn
 * @date 2018/8/12
 * @since JDK 1.8
 */
public class NameValue {
    private String name;
    private String value;

    @JSONCreator
    public NameValue(@JSONField(name = "name") String name, @JSONField(name = "value") String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "NameValue{" +
                       "name='" + name + '\'' +
                       ", value='" + value + '\'' +
                       '}';
    }
}
