package com.francis.speeroad.entity;

/**
 * token entity
 * @author hzzhugequn
 * @date 2018/8/4
 * @since JDK 1.8
 */
public class EMToken {

    /** token值 */
    String token;

    /** 过期时间，单位：秒 */
    int expire;

    /** 当前APP的UUID值 */
    String application;

    public EMToken() {
    }

    public EMToken(String token, int expire, String application) {
        this.token = token;
        this.expire = expire;
        this.application = application;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getExpire() {
        return expire;
    }

    public void setExpire(int expire) {
        this.expire = expire;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    @Override
    public String toString() {
        return "EMToken{" +
                       "token='" + token + '\'' +
                       ", expire=" + expire +
                       ", application='" + application + '\'' +
                       '}';
    }
}
