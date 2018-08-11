package com.francis.speeroad.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author hzzhugequn
 * @date 2018/8/4
 * @since JDK 1.8
 */
@Configuration
@PropertySource("classpath:properties/http.properties")
public class HttpConfig {
    @Value("${max.connection}")
    private int maxConnection;
    @Value("${default.max.connection}")
    private int defaultMaxConnection;
    @Value("${easemob.host}")
    private String easemobHost;
    @Value("${easemob.org.name}")
    private String easemobOrgName;
    @Value("${easemob.app.name}")
    private String easemobAppName;
    @Value("${easemob.token.path}")
    private String tokenPath;
    @Value("${easemob.client.id}")
    private String clientId;
    @Value("${easemob.client.secret}")
    private String clientSecret;
    @Value("${easemob.grant.type}")
    private String grantType;

    /**
     * 获取tokenUrl
     *
     * @return tokenUrl
     */
    public String getAppTokenUrl() {
        return easemobHost + "/" + easemobOrgName + "/" + easemobAppName + "/" + tokenPath;
    }

    /**
     * 获取当个IM注册url
     *
     * @return url
     */
    public String getRegisterSingleUrl() {
        return easemobHost + "/" + easemobOrgName + "/" + easemobAppName + "/" + "users";
    }

    /**
     * 获取单个IM的url
     *
     * @return
     */
    public String getGetSingleUrl(String username) {
        return easemobHost + "/" + easemobOrgName + "/" + easemobAppName + "/" + "users" + "/" + username;
    }

    /**
     * 删除单个IM的url
     *
     * @return
     */
    public String getDelSingleUrl(String username) {
        return easemobHost + "/" + easemobOrgName + "/" + easemobAppName + "/" + "users" + "/" + username;
    }

    /**
     * 重置IM用户密码的url
     *
     * @param username
     * @return
     */
    public String getResetPasswordUrl(String username) {
        return easemobHost + "/" + easemobOrgName + "/" + easemobAppName + "/" + "users" + "/" + username + "/" + "password";
    }

    /**
     * 重置IM用户nickname
     *
     * @param username 用户名
     * @return
     */
    public String getResetNicknameUrl(String username) {
        return easemobHost + "/" + easemobOrgName + "/" + easemobAppName + "/" + "users" + "/" + username;
    }

    /**
     * 增加朋友路径
     *
     * @param ownUsername    要添加好友的用户名
     * @param friendUsername 被添加的用户名
     * @return
     */
    public String getAddFriendUrl(String ownUsername, String friendUsername) {
        return easemobHost + "/" + easemobOrgName + "/" + easemobAppName + "/" + "users" + "/" + ownUsername + "/contacts/users/" + friendUsername;
    }

    /**
     * 删除朋友路径
     *
     * @param ownUsername    要删除好友的用户名
     * @param friendUsername 被删除的用户名
     * @return
     */
    public String getDelFriendUrl(String ownUsername, String friendUsername) {
        return easemobHost + "/" + easemobOrgName + "/" + easemobAppName + "/" + "users" + "/" + ownUsername + "/contacts/users/" + friendUsername;
    }

    /**
     * 获取朋友路径
     *
     * @param username 要获取好友的用户名
     * @return
     */
    public String getGetFriendUrl(String username) {
        return easemobHost + "/" + easemobOrgName + "/" + easemobAppName + "/" + "users" + "/" + username + "/contacts/users/";
    }


    public int getMaxConnection() {
        return maxConnection;
    }

    public int getDefaultMaxConnection() {
        return defaultMaxConnection;
    }

    public String getEasemobHost() {
        return easemobHost;
    }

    public String getEasemobOrgName() {
        return easemobOrgName;
    }

    public String getEasemobAppName() {
        return easemobAppName;
    }

    public String getTokenPath() {
        return tokenPath;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public String getGrantType() {
        return grantType;
    }

}
