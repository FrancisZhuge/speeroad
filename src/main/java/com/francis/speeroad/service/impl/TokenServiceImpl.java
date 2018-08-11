package com.francis.speeroad.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.francis.speeroad.conf.HttpConfig;
import com.francis.speeroad.entity.EMToken;
import com.francis.speeroad.exception.CacheNotExistException;
import com.francis.speeroad.exception.http.HttpException;
import com.francis.speeroad.service.CacheService;
import com.francis.speeroad.service.HttpService;
import com.francis.speeroad.service.TokenService;
import com.francis.speeroad.util.CacheUtil;

/**
 * token 具体服务类
 *
 * @author hzzhugequn
 * @date 2018/8/4
 * @since JDK 1.8
 */
@Service
public class TokenServiceImpl implements TokenService {

    private static Logger logger = LoggerFactory.getLogger(TokenServiceImpl.class);

    @Autowired
    CacheService cacheService;

    @Autowired
    HttpService httpService;

    @Autowired
    HttpConfig httpConfig;

    @Override
    public EMToken getToken() throws HttpException {
        String key = CacheUtil.getTokenKey();
        try {
            String value = cacheService.get(key);
            return JSON.parseObject(value, EMToken.class);
        } catch (CacheNotExistException e) {
            //从远程获取token
            String url = httpConfig.getAppTokenUrl();
            System.out.println(url);
            String body = getTokenRequestBody();
            String value = httpService.post(url, null, body);
            JSONObject jsonObject = JSONObject.parseObject(value);
            EMToken token = new EMToken();
            token.setApplication(jsonObject.getString("application"));
            //减掉10秒钟，防止边界问题
            token.setExpire(jsonObject.getInteger("expires_in") - 10);
            token.setToken(jsonObject.getString("access_token"));
            logger.info("[getToken] token:{}", token);
            cacheService.put(key, JSON.toJSONString(token), token.getExpire());
            return token;
        }
    }


    /**
     * 获取TOKEN的请求体
     *
     * @return token请求体
     */
    private String getTokenRequestBody() {
        String grantType = httpConfig.getGrantType();
        String clientId = httpConfig.getClientId();
        String clientSecret = httpConfig.getClientSecret();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("grant_type", grantType);
        jsonObject.put("client_id", clientId);
        jsonObject.put("client_secret", clientSecret);
        return jsonObject.toJSONString();
    }
}
