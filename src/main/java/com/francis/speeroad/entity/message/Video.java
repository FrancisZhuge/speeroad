package com.francis.speeroad.entity.message;

import com.alibaba.fastjson.annotation.JSONField;
import com.francis.speeroad.entity.type.MessageType;

/**
 * 视频消息:需要先上传视频文件和视频缩略图文件，然后再发送此消息。（url中的uuid和secret可以从上传后的response获取）
 *
 * @author hzzhugequn
 * @date 2018/8/12
 * @since JDK 1.8
 */
public class Video extends Notify {
    /**
     * 语音附件大小(字节)
     */
    @JSONField(name = "file_length")
    private int fileLength;

    private String filename;

    private int length; //视频时间(单位s)

    private String secret; // 成功上传视频文件后返回的secret

    @JSONField(name = "size")
    private ImageSize size;

    private String thumb; // 成功上传视频缩略图返回的uuid

    @JSONField(name = "thumb_secret")
    private String thumbSecret; // 成功上传视频缩略图后返回的secret

    private String url; // 成功上传视频文件返回的uuid

    public Video() {
        super(MessageType.video);
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

    public ImageSize getSize() {
        return size;
    }

    public void setSize(ImageSize size) {
        this.size = size;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getThumbSecret() {
        return thumbSecret;
    }

    public void setThumbSecret(String thumbSecret) {
        this.thumbSecret = thumbSecret;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Video{" +
                       "fileLength=" + fileLength +
                       ", filename='" + filename + '\'' +
                       ", length=" + length +
                       ", secret='" + secret + '\'' +
                       ", size=" + size +
                       ", thumb='" + thumb + '\'' +
                       ", thumbSecret='" + thumbSecret + '\'' +
                       ", url='" + url + '\'' +
                       '}';
    }
}
