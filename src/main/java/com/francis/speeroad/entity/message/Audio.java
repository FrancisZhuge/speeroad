package com.francis.speeroad.entity.message;

import com.alibaba.fastjson.annotation.JSONField;
import com.francis.speeroad.entity.type.MessageType;

/**
 * 语音消息
 * @author hzzhugequn
 * @date 2018/8/12
 * @since JDK 1.8
 */
public class Audio extends Notify{
    /**
     * 语音附件大小(字节)
     */
    @JSONField(name = "file_length")
    private int fileLength;

    private String filename; // 语音名称

    private int length; //语音时间(单位s)

    private String secret;

    private String url;

    public Audio() {
        super(MessageType.audio);
    }

    public int getFileLength() {
        return fileLength;
    }

    public void setFileLength(int fileLength) {
        this.fileLength = fileLength;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Audio{" +
                       "fileLength=" + fileLength +
                       ", filename='" + filename + '\'' +
                       ", length=" + length +
                       ", secret='" + secret + '\'' +
                       ", url='" + url + '\'' +
                       '}';
    }
}
