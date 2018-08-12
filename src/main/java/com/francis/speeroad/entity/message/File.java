package com.francis.speeroad.entity.message;

import com.alibaba.fastjson.annotation.JSONField;
import com.francis.speeroad.entity.type.MessageType;

/**
 * @author hzzhugequn
 * @date 2018/8/12
 * @since JDK 1.8
 */
public class File extends Notify{
    /**
     * 文件附件大小(字节)
     */
    @JSONField(name = "file_length")
    private int fileLength;

    private String filename;

    private String secret;

    private String url;

    public File() {
        super(MessageType.file);
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
        return "File{" +
                       "fileLength=" + fileLength +
                       ", filename='" + filename + '\'' +
                       ", secret='" + secret + '\'' +
                       ", url='" + url + '\'' +
                       '}';
    }
}
