package com.francis.speeroad.exception.http;

import com.francis.speeroad.exception.BaseException;

/**
 * http服务异常基础类
 *
 * @author hzzhugequn
 * @date 2018/8/4
 * @since JDK 1.8
 */
public class HttpException extends BaseException {

    public HttpException() {
    }

    public HttpException(String message) {
        super(message);
    }

    public HttpException(String message, Throwable cause) {
        super(message, cause);
    }

    public HttpException(Throwable cause) {
        super(cause);
    }
}
