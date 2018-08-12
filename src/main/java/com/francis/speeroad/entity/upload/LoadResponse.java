package com.francis.speeroad.entity.upload;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author hzzhugequn
 * @date 2018/8/12
 * @since JDK 1.8
 */
public class LoadResponse {
    private String uuid;
    private String type;
    @JSONField(name = "share-secret")
    private String shareSecret;

    public LoadResponse() {
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getShareSecret() {
        return shareSecret;
    }

    public void setShareSecret(String shareSecret) {
        this.shareSecret = shareSecret;
    }

    @Override
    public String toString() {
        return "UpResponse{" +
                       "uuid='" + uuid + '\'' +
                       ", type='" + type + '\'' +
                       ", shareSecret='" + shareSecret + '\'' +
                       '}';
    }
}
