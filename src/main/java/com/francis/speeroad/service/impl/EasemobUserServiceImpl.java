package com.francis.speeroad.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.francis.speeroad.conf.HttpConfig;
import com.francis.speeroad.entity.EaseMobUser;
import com.francis.speeroad.exception.BaseException;
import com.francis.speeroad.service.EasemobUserService;
import com.francis.speeroad.service.HttpService;
import com.francis.speeroad.token.TokenService;

/**
 * 环信 服务类实现类
 *
 * @author hzzhugequn
 * @date 2018/8/4
 * @since JDK 1.8
 */
@Service
public class EasemobUserServiceImpl implements EasemobUserService {

    @Autowired
    TokenService tokenService;

    @Autowired
    HttpConfig httpConfig;

    @Autowired
    HttpService httpService;

    @Override
    public EaseMobUser registerSingle(String username, String password, String nickname) throws BaseException {
        String url = httpConfig.getRegisterSingleUrl();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", username);
        jsonObject.put("password", password);
        if (StringUtils.isNotBlank(nickname)) {
            jsonObject.put("nickname", nickname);
        }
        String params = jsonObject.toJSONString();
        String value = "Bearer " + tokenService.getToken().getToken();
        Header header = new BasicHeader("Authorization", value);
        List<Header> headers = new ArrayList<>();
        headers.add(header);
        String returnValue = httpService.post(url, headers, params);
        JSONObject entity = JSON.parseObject(returnValue).getJSONArray("entities").getJSONObject(0);
        EaseMobUser user = new EaseMobUser();
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
    public EaseMobUser getSingle(String username) throws BaseException {
        String url = httpConfig.getGetSingleUrl(username);
        String value = "Bearer " + tokenService.getToken().getToken();
        Header header = new BasicHeader("Authorization", value);
        List<Header> headers = new ArrayList<>();
        headers.add(header);
        String returnValue = httpService.get(url, headers);
        JSONObject entity = JSON.parseObject(returnValue).getJSONArray("entities").getJSONObject(0);
        EaseMobUser user = new EaseMobUser();
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
    public EaseMobUser delSingle(String username) throws BaseException {
        String url = httpConfig.getDelSingleUrl(username);
        String value = "Bearer " + tokenService.getToken().getToken();
        Header header = new BasicHeader("Authorization", value);
        List<Header> headers = new ArrayList<>();
        headers.add(header);
        String returnValue = httpService.delete(url, headers);
        JSONObject entity = JSON.parseObject(returnValue).getJSONArray("entities").getJSONObject(0);
        EaseMobUser user = new EaseMobUser();
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
    public EaseMobUser resetSingle(String username, String password) throws BaseException {
        String url = httpConfig.getResetPasswordUrl(username);
        String value = "Bearer " + tokenService.getToken().getToken();
        Header header = new BasicHeader("Authorization", value);
        List<Header> headers = new ArrayList<>();
        headers.add(header);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("newpassword", password);
        String params = jsonObject.toJSONString();
        String returnValue = httpService.put(url, headers, params);
        JSONObject entity = JSON.parseObject(returnValue);
        EaseMobUser user = new EaseMobUser();
        user.setModified(entity.getLong("timestamp"));
        return user;
    }

    @Override
    public EaseMobUser resetNickname(String username, String nickname) throws BaseException {
        String url = httpConfig.getResetNicknameUrl(username);
        String value = "Bearer " + tokenService.getToken().getToken();
        Header header = new BasicHeader("Authorization", value);
        List<Header> headers = new ArrayList<>();
        headers.add(header);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("nickname", nickname);
        String params = jsonObject.toJSONString();
        String returnValue = httpService.put(url, headers, params);
        JSONObject entity = JSON.parseObject(returnValue);
        System.out.println(entity);

        return null;
    }

    @Override
    public EaseMobUser addFriend(String ownerUsername, String friendUsername) throws BaseException {
        String url = httpConfig.getAddFriendUrl(ownerUsername, friendUsername);
        String value = "Bearer " + tokenService.getToken().getToken();
        Header header = new BasicHeader("Authorization", value);
        List<Header> headers = new ArrayList<>();
        headers.add(header);
        String returnValue = httpService.post(url, headers, "");
        JSONObject entity = JSON.parseObject(returnValue).getJSONArray("entities").getJSONObject(0);
        EaseMobUser user = new EaseMobUser();
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
    public EaseMobUser delFriend(String ownerUsername, String friendUsername) throws BaseException {
        String url = httpConfig.getDelFriendUrl(ownerUsername, friendUsername);
        String value = "Bearer " + tokenService.getToken().getToken();
        Header header = new BasicHeader("Authorization", value);
        List<Header> headers = new ArrayList<>();
        headers.add(header);
        String returnValue = httpService.delete(url, headers);
        JSONObject entity = JSON.parseObject(returnValue).getJSONArray("entities").getJSONObject(0);
        EaseMobUser user = new EaseMobUser();
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
        String url = httpConfig.getGetFriendUrl(username);
        String value = "Bearer " + tokenService.getToken().getToken();
        Header header = new BasicHeader("Authorization", value);
        List<Header> headers = new ArrayList<>();
        headers.add(header);
        String returnValue = httpService.get(url, headers);
        JSONArray entities = JSON.parseObject(returnValue).getJSONArray("data");
        List<String> friends = new ArrayList<>();
        for (int i = 0; i < entities.size(); i++) {
            friends.add(entities.getString(i));
        }
        return friends;
    }

    @Override
    public Boolean getStatus(String username) throws BaseException {
        String url = httpConfig.getGetStatusUrl(username);
        String value = "Bearer " + tokenService.getToken().getToken();
        Header header = new BasicHeader("Authorization", value);
        List<Header> headers = new ArrayList<>();
        headers.add(header);
        String returnValue = httpService.get(url, headers);
        String status = JSONObject.parseObject(returnValue).getJSONObject("data").getString(username);
        return (status.equals("online"));
    }

    @Override
    public Long getOfflineCounts(String username) throws BaseException {
        String url = httpConfig.getOfflineCountsUrl(username);
        String value = "Bearer " + tokenService.getToken().getToken();
        Header header = new BasicHeader("Authorization", value);
        List<Header> headers = new ArrayList<>();
        headers.add(header);
        String returnValue = httpService.get(url, headers);
        long counts = JSONObject.parseObject(returnValue).getJSONObject("data").getLong(username);
        return counts;
    }

    @Override
    public Boolean getOfflineStatus(String username, long message_id) throws BaseException {
        String url = httpConfig.getOfflineStatusUrl(username, message_id);
        String value = "Bearer " + tokenService.getToken().getToken();
        Header header = new BasicHeader("Authorization", value);
        List<Header> headers = new ArrayList<>();
        headers.add(header);
        String returnValue = httpService.get(url, headers);
        String status = JSONObject.parseObject(returnValue).getJSONObject("data").getString(username);
        return (status.equals("delivered"));
    }

    @Override
    public EaseMobUser deactivate(String username) throws BaseException {
        String url = httpConfig.getDeactivateUrl(username);
        String value = "Bearer " + tokenService.getToken().getToken();
        Header header = new BasicHeader("Authorization", value);
        List<Header> headers = new ArrayList<>();
        headers.add(header);
        String returnValue = httpService.post(url, headers, "");
        JSONObject entity = JSON.parseObject(returnValue).getJSONArray("entities").getJSONObject(0);
        EaseMobUser user = new EaseMobUser();
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
    public EaseMobUser activate(String username) throws BaseException {
        String url = httpConfig.getActivateUrl(username);
        String value = "Bearer " + tokenService.getToken().getToken();
        Header header = new BasicHeader("Authorization", value);
        List<Header> headers = new ArrayList<>();
        headers.add(header);
        String returnValue = httpService.post(url, headers, "");
        JSONObject entity = JSON.parseObject(returnValue);
        EaseMobUser user = new EaseMobUser();
        user.setModified(entity.getLong("timestamp"));
        return user;
    }

    @Override
    public Boolean disConnect(String username) throws BaseException {
        String url = httpConfig.getDisConnectUrl(username);
        String value = "Bearer " + tokenService.getToken().getToken();
        Header header = new BasicHeader("Authorization", value);
        List<Header> headers = new ArrayList<>();
        headers.add(header);
        String returnValue = httpService.get(url, headers);
        String status = JSONObject.parseObject(returnValue).getJSONObject("data").getString("result");
        return status.equals("true");
    }
}
