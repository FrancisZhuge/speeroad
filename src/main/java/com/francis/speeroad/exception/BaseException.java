package com.francis.speeroad.exception;

/**
 * 项目中的异常基类
 *
 * @author hzzhugequn
 * @date 2018/8/4
 * @since JDK 1.8
 */
public class BaseException extends Exception {

    public BaseException() {
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }
}
