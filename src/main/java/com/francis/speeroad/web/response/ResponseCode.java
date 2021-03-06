package com.francis.speeroad.web.response;

/**
 * @author hzzhugequn
 * @date 2018/8/4
 * @since JDK 1.8
 */
public class ResponseCode {
    /**
     * 正常返回
     */
    public final static int S_OK = 200;

    /**
     * 访问了服务器，但是没有任何的修改
     */
    public final static int S_NOCHANGE = 201;

    /**
     * 错误参数
     */
    public final static int F_ILLEGAL_ARGUS = 400;

    /**
     * 未授权
     */
    public final static int F_UNAUTH = 401;

    /**
     * 访问地址不对
     */
    public final static int F_IP_DENIED = 403;

    /**
     * 服务器错误
     */
    public final static int F_SERVER_ERROR = 500;
}
