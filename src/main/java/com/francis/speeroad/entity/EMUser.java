package com.francis.speeroad.entity;

/**
 * EM user
 *
 * @author hzzhugequn
 * @date 2018/8/5
 * @since JDK 1.8
 */
public class EMUser {
    private long id;
    private String username;
    private String password;
    private String nickname;
    private String uuid;
    private String type;
    private long created;
    private long modified;
    private boolean activated;
    private String deviceToken;

    public EMUser() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public long getModified() {
        return modified;
    }

    public void setModified(long modified) {
        this.modified = modified;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    @Override
    public String toString() {
        return "EMUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", uuid='" + uuid + '\'' +
                ", type='" + type + '\'' +
                ", created=" + created +
                ", modified=" + modified +
                ", activated=" + activated +
                ", deviceToken='" + deviceToken + '\'' +
                '}';
    }
}
