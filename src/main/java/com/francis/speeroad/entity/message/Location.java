package com.francis.speeroad.entity.message;

import com.alibaba.fastjson.annotation.JSONField;
import com.francis.speeroad.entity.type.MessageType;

/**
 * @author hzzhugequn
 * @date 2018/8/12
 * @since JDK 1.8
 */
public class Location extends Notify{
    /**
     * 要发送的地址
     */
    @JSONField(name = "addr")
    private String address;
    /**
     * 纬度
     */
    private double lat;

    /**
     * 经度
     */
    private double lng;

    public Location() {
        super(MessageType.loc);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        return "Location{" +
                       "address='" + address + '\'' +
                       ", lat=" + lat +
                       ", lng=" + lng +
                       '}';
    }
}
