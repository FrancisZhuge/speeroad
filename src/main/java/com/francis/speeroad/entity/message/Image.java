package com.francis.speeroad.entity.message;

import com.alibaba.fastjson.annotation.JSONField;
import com.francis.speeroad.entity.type.MessageType;

/**
 * 图片消息:给一个或者多个用户, 或者一个或者多个群组发送消息, 并且通过可选的 from 字段让接收方看到发送方是不同的人,同时, 支持扩展字段, 通过
 * ext 属性, app可以发送自己专属的消息结构.
 * @author hzzhugequn
 * @date 2018/8/12
 * @since JDK 1.8
 */
public class Image extends Notify{
    /**
     * 上传图片消息地址，在上传图片成功后会返回UUID
     */
    private String url;

    /**
     * 文件名称
     */
    private String filename;

    /**
     * secret在上传图片后会返回，只有含有secret才能够下载此图片
     */
    private String secret;

    @JSONField(name = "size")
    private ImageSize size;

    /**
     * 图片附件大小(单位字节)
     */
    @JSONField(name = "file_length")
    private int fileLength;

    public Image() {
        super(MessageType.img);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public ImageSize getSize() {
        return size;
    }

    public void setSize(ImageSize size) {
        this.size = size;
    }

    public int getFileLength() {
        return fileLength;
    }

    public void setFileLength(int fileLength) {
        this.fileLength = fileLength;
    }

    @Override
    public String toString() {
        return "Image{" +
                       "url='" + url + '\'' +
                       ", filename='" + filename + '\'' +
                       ", secret='" + secret + '\'' +
                       ", size=" + size +
                       ", fileLength=" + fileLength +
                       '}';
    }
}
