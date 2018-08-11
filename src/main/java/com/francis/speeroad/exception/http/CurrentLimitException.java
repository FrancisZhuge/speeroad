package com.francis.speeroad.exception.http;

/**
 * 限流异常
 *
 * @author hzzhugequn
 * @date 2018/8/4
 * @since JDK 1.8
 */
public class CurrentLimitException extends HttpException {

    public CurrentLimitException() {
    }

    public CurrentLimitException(String message) {
        super(message);
    }

    public CurrentLimitException(String message, Throwable cause) {
        super(message, cause);
    }

    public CurrentLimitException(Throwable cause) {
        super(cause);
    }
}
