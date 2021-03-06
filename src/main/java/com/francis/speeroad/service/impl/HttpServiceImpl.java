package com.francis.speeroad.service.impl;

import java.io.IOException;
import java.util.List;

import com.francis.speeroad.entity.message.File;
import com.francis.speeroad.exception.http.UserNotExistException;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.*;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.francis.speeroad.exception.http.CurrentLimitException;
import com.francis.speeroad.exception.http.HttpException;
import com.francis.speeroad.http.HttpManager;
import com.francis.speeroad.service.HttpService;

/**
 * http服务类实现类
 *
 * @author hzzhugequn
 * @date 2018/8/4
 * @since JDK 1.8
 */
@Service
public class HttpServiceImpl implements HttpService {

    private static Logger logger = LoggerFactory.getLogger(HttpService.class);

    @Autowired
    HttpManager httpManager;


    @Override
    public String post(String url, List<Header> headers, String body) throws HttpException {
        String returnValue = null;
        CloseableHttpClient client = httpManager.getHttpClient();
        HttpPost post = new HttpPost(url);
        if (StringUtils.isNotBlank(body)) {
            StringEntity stringEntity = new StringEntity(body, ContentType.create("text/plain", "UTF-8"));
            post.setEntity(stringEntity);
        }
        if (headers != null && headers.size() != 0) {
            for (Header header : headers){
                post.setHeader(header);
            }
        }
        post.setHeader("Content-Type", "application/json");
        CloseableHttpResponse response = null;
        try {
            response = client.execute(post);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 429) {
                throw new CurrentLimitException();
            }
            if (statusCode == 200) {
                HttpEntity entity = response.getEntity();
                returnValue = new String(EntityUtils.toByteArray(entity), "UTF-8");
                return returnValue;
            }
            return null;
        } catch (IOException e) {
            logger.error("[post] err. url:{}, body{}.", url, body);
            throw new HttpException(e);
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                logger.error("[post] close err.");
            }
        }
    }

    @Override
    public String get(String url, List<Header> headers) throws HttpException {
        String returnValue = null;
        CloseableHttpClient client = httpManager.getHttpClient();
        HttpGet get = new HttpGet(url);
        if (headers != null && headers.size() != 0) {
            for (Header header : headers){
                get.setHeader(header);
            }
        }
        get.setHeader("Content-Type", "application/json");
        CloseableHttpResponse response = null;
        try {
            response = client.execute(get);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 429) {
                throw new CurrentLimitException();
            }
            if (statusCode == 200) {
                HttpEntity entity = response.getEntity();
                returnValue = new String(EntityUtils.toByteArray(entity), "UTF-8");
                return returnValue;
            }
            return null;
        } catch (IOException e) {
            logger.error("[get] err. url:{}.", url);
            throw new HttpException(e);
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                logger.error("[get] close err.");
            }
        }
    }

    @Override
    public String delete(String url, List<Header> headers) throws HttpException {
        String returnValue = null;
        CloseableHttpClient client = httpManager.getHttpClient();
        HttpDelete delete = new HttpDelete(url);
        if (headers != null && headers.size() != 0) {
            for (Header header : headers){
                delete.setHeader(header);
            }
        }
        delete.setHeader("Content-Type", "application/json");
        CloseableHttpResponse response = null;
        try {
            response = client.execute(delete);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 429) {
                throw new CurrentLimitException();
            }
            if (statusCode == 200) {
                HttpEntity entity = response.getEntity();
                returnValue = new String(EntityUtils.toByteArray(entity), "UTF-8");
                return returnValue;
            }
            return null;
        } catch (IOException e) {
            logger.error("[delete] err. url:{}.", url);
            throw new HttpException(e);
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                logger.error("[delete] close err.");
            }
        }
    }

    @Override
    public String put(String url, List<Header> headers, String body) throws HttpException{
        String returnValue = null;
        CloseableHttpClient client = httpManager.getHttpClient();
        HttpPut put = new HttpPut(url);
        if (StringUtils.isNotBlank(body)) {
            StringEntity stringEntity = new StringEntity(body, ContentType.create("text/plain", "UTF-8"));
            put.setEntity(stringEntity);
        }
        if (headers != null && headers.size() != 0) {
            for (Header header : headers){
                put.setHeader(header);
            }
        }
        put.setHeader("Content-Type", "application/json");
        CloseableHttpResponse response = null;
        try {
            response = client.execute(put);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 429) {
                throw new CurrentLimitException();
            }
            if (statusCode == 404 ){
                throw new UserNotExistException();
            }
            if (statusCode == 200) {
                HttpEntity entity = response.getEntity();
                returnValue = new String(EntityUtils.toByteArray(entity), "UTF-8");
                return returnValue;
            }
            return null;
        } catch (IOException e) {
            logger.error("[put] err. url:{}.", url);
            throw new HttpException(e);
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                logger.error("[put] close err.");
            }
        }
    }

    @Override
    public String post(String url, List<Header> headers, File file) throws HttpException {
        return null;
    }
}
