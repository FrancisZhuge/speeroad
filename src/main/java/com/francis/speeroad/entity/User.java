package com.francis.speeroad.entity;

/**
 * @author francis
 * @className
 * @date 2018/8/12
 * @see
 * @since JDK 1.8
 */
public class User {
    private int id;
    private String username;
    private String password;
    private String easePassword;
    private String salt;
    private String uuid;
    private long createTime;
    private long modifyTime;
    private String deviceToken;
    private boolean active;
    private String nickname;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEasePassword() {
        return easePassword;
    }

    public void setEasePassword(String easePassword) {
        this.easePassword = easePassword;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(long modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", easePassword='" + easePassword + '\'' +
                ", salt='" + salt + '\'' +
                ", uuid='" + uuid + '\'' +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                ", deviceToken='" + deviceToken + '\'' +
                ", active=" + active +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
