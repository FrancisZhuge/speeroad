package com.francis.speeroad.service;


import org.apache.http.Header;

import com.francis.speeroad.exception.http.HttpException;

/**
 * http服务类
 *
 * @author hzzhugequn
 * @date 2018/8/4
 * @since JDK 1.8
 */
public interface HttpService {

    /**
     * 发送post请求
     *
     * @param url    请求地址
     * @param header 请求头
     * @param body   参数
     * @return
     */
    String post(String url, Header header, String body) throws HttpException;

    /**
     * 发送get请求
     *
     * @param url    请求地址
     * @param header 请求头
     * @return
     * @throws HttpException
     */
    String get(String url, Header header) throws HttpException;

    /**
     * 发送delete请求
     *
     * @param url    请求地址
     * @param header 请求头
     * @return
     */
    String delete(String url, Header header) throws HttpException;

    /**
     * 发送put请求
     *
     * @param url    请求地址
     * @param header 请求头
     * @param body   参数
     * @return
     * @throws HttpException
     */
    String put(String url, Header header, String body) throws HttpException;
}
