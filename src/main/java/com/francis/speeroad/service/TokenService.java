package com.francis.speeroad.service;

import com.francis.speeroad.entity.EMToken;
import com.francis.speeroad.exception.http.HttpException;

/**
 * token服务类
 *
 * @author hzzhugequn
 * @date 2018/8/4
 * @since JDK 1.8
 */
public interface TokenService {
    /**
     * 获取当前app的token
     *
     * @return
     * @throws HttpException
     */
    EMToken getToken() throws HttpException;
}
