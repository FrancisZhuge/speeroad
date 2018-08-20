package com.francis.speeroad.entity;

import java.util.Date;

/**
 * token类
 * @author francis
 * @className
 * @date 2018/8/12
 * @see
 * @since JDK 1.8
 */
public class Token {
    private int id;
    private long userId;
    private String token;
    private Date expired;
    private boolean status;

    public Token() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExpired() {
        return expired;
    }

    public void setExpired(Date expired) {
        this.expired = expired;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Token{" +
                "id=" + id +
                ", userId=" + userId +
                ", token='" + token + '\'' +
                ", expired=" + expired +
                ", status=" + status +
                '}';
    }
}
