package com.francis.speeroad.entity.message;

/**
 * 图片大小信息
 * @author hzzhugequn
 * @date 2018/8/12
 * @since JDK 1.8
 */
public class ImageSize {
    private int height;
    private int width;

    public ImageSize() {
    }

    public ImageSize(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "ImageSize{" +
                       "height=" + height +
                       ", width=" + width +
                       '}';
    }
}
