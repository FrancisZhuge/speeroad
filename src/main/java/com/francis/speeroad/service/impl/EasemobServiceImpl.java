package com.francis.speeroad.service.impl;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.francis.speeroad.entity.EMToken;
import com.francis.speeroad.exception.http.HttpException;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.francis.speeroad.conf.HttpConfig;
import com.francis.speeroad.entity.EMUser;
import com.francis.speeroad.exception.BaseException;
import com.francis.speeroad.service.EasemobService;
import com.francis.speeroad.service.HttpService;
import com.francis.speeroad.service.TokenService;

/**
 * 环信 服务类实现类
 *
 * @author hzzhugequn
 * @date 2018/8/4
 * @since JDK 1.8
 */
@Service
public class EasemobServiceImpl implements EasemobService {

    @Autowired
    TokenService tokenService;

    @Autowired
    HttpConfig httpConfig;

    @Autowired
    HttpService httpService;

    @Override
    public EMUser registerSingle(String username, String password, String nickname) throws BaseException {
        String url = httpConfig.getRegisterSingleUrl();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", username);
        jsonObject.put("password", password);
        if (StringUtils.isNotBlank(nickname)){
            jsonObject.put("nickname", nickname);
        }
        String params = jsonObject.toJSONString();
        String value = "Bearer "+ tokenService.getToken().getToken();
        Header header = new BasicHeader("Authorization", value);
        String returnValue = httpService.post(url, header, params);
        JSONObject entity = JSON.parseObject(returnValue).getJSONArray("entities").getJSONObject(0);
        EMUser user = new EMUser();
        user.setCreated(entity.getLong("created"));
        user.setNickname(entity.getString("nickname"));
        user.setModified(entity.getLong("modified"));
        user.setType(entity.getString("type"));
        user.setUuid(entity.getString("uuid"));
        user.setUsername(entity.getString("username"));
        user.setActivated(entity.getBoolean("activated"));
        return user;
    }

    @Override
    public EMUser getSingle(String username) throws BaseException {
        String url = httpConfig.getGetSingleUrl(username);
        String value = "Bearer "+ tokenService.getToken().getToken();
        Header header = new BasicHeader("Authorization", value);
        String returnValue = httpService.get(url, header);
        JSONObject entity = JSON.parseObject(returnValue).getJSONArray("entities").getJSONObject(0);
        EMUser user = new EMUser();
        user.setCreated(entity.getLong("created"));
        user.setNickname(entity.getString("nickname"));
        user.setModified(entity.getLong("modified"));
        user.setType(entity.getString("type"));
        user.setUuid(entity.getString("uuid"));
        user.setUsername(entity.getString("username"));
        user.setActivated(entity.getBoolean("activated"));
        return user;
    }

    @Override
    public EMUser delSingle(String username) throws BaseException {
        String url = httpConfig.getDelSingleUrl(username);
        String value = "Bearer "+ tokenService.getToken().getToken();
        Header header = new BasicHeader("Authorization", value);
        String returnValue = httpService.delete(url, header);
        JSONObject entity = JSON.parseObject(returnValue).getJSONArray("entities").getJSONObject(0);
        EMUser user = new EMUser();
        user.setCreated(entity.getLong("created"));
        user.setNickname(entity.getString("nickname"));
        user.setModified(entity.getLong("modified"));
        user.setType(entity.getString("type"));
        user.setUuid(entity.getString("uuid"));
        user.setUsername(entity.getString("username"));
        user.setActivated(entity.getBoolean("activated"));
        return user;
    }

    @Override
    public EMUser resetSingle(String username, String password) throws BaseException {
        String url = httpConfig.getResetPasswordUrl(username);
        String value = "Bearer "+ tokenService.getToken().getToken();
        Header header = new BasicHeader("Authorization", value);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("newpassword", password);
        String params = jsonObject.toJSONString();
        String returnValue = httpService.put(url, header, params);
        JSONObject entity = JSON.parseObject(returnValue);
        EMUser user = new EMUser();
        user.setModified(entity.getLong("timestamp"));
        return user;
    }

    @Override
    public EMUser resetNickname(String username, String nickname) throws BaseException {
        String url = httpConfig.getResetNicknameUrl(username);
        String value = "Bearer "+ tokenService.getToken().getToken();
        Header header = new BasicHeader("Authorization", value);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("nickname", nickname);
        String params = jsonObject.toJSONString();
        String returnValue = httpService.put(url, header, params);
        JSONObject entity = JSON.parseObject(returnValue);
        System.out.println(entity);

        return null;
    }

    @Override
    public EMUser addFriend(String ownerUsername, String friendUsername) throws BaseException {
        String url = httpConfig.getAddFriendUrl(ownerUsername, friendUsername);
        String value = "Bearer "+ tokenService.getToken().getToken();
        Header header = new BasicHeader("Authorization", value);
        String returnValue = httpService.post(url, header, null);
        JSONObject entity = JSON.parseObject(returnValue).getJSONArray("entities").getJSONObject(0);
        EMUser user = new EMUser();
        user.setCreated(entity.getLong("created"));
        user.setModified(entity.getLong("modified"));
        user.setNickname(entity.getString("nickname"));
        user.setType(entity.getString("type"));
        user.setUuid(entity.getString("uuid"));
        user.setUsername(entity.getString("username"));
        user.setActivated(entity.getBoolean("activated"));
        return user;
    }

    @Override
    public EMUser delFriend(String ownerUsername, String friendUsername) throws BaseException {
        String url = httpConfig.getDelFriendUrl(ownerUsername, friendUsername);
        String value = "Bearer "+ tokenService.getToken().getToken();
        Header header = new BasicHeader("Authorization", value);
        String returnValue = httpService.delete(url, header);
        JSONObject entity = JSON.parseObject(returnValue).getJSONArray("entities").getJSONObject(0);
        EMUser user = new EMUser();
        user.setCreated(entity.getLong("created"));
        user.setModified(entity.getLong("modified"));
        user.setNickname(entity.getString("nickname"));
        user.setType(entity.getString("type"));
        user.setUuid(entity.getString("uuid"));
        user.setUsername(entity.getString("username"));
        user.setActivated(entity.getBoolean("activated"));
        return user;
    }

    @Override
    public List<String> getFriend(String username) throws BaseException {
        return null;
    }

    @Override
    public Boolean getStatus(String username) throws BaseException {
        return null;
    }

    @Override
    public Long getOfflineCounts(String usernmae) throws BaseException {
        return null;
    }

    @Override
    public Boolean getOfflineStatus(String message_id) throws BaseException {
        return null;
    }

    @Override
    public EMUser Deactivate(String username) throws BaseException {
        return null;
    }

    @Override
    public Boolean Activate(String username) throws BaseException {
        return null;
    }

    @Override
    public Boolean disConnect(String username) throws BaseException {
        return null;
    }
}
