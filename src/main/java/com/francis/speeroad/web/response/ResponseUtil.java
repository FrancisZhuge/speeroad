package com.francis.speeroad.web.response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

/**
 * http返回工具类
 *
 * @author hzzhugequn
 * @date 2018/8/4
 * @since JDK 1.8
 */
public class ResponseUtil {

    private static Logger logger = LoggerFactory.getLogger(ResponseUtil.class);

    /**
     * 返回成功
     *
     * @param object data
     * @return
     */
    public static String responseOk(Object object) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", ResponseCode.S_OK);
        if (object != null) {
            jsonObject.put("data", object);
        }
        return jsonObject.toJSONString();
    }

    /**
     * 参数错误
     *
     * @return
     */
    public static String responseIllegalArgus() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", ResponseCode.F_ILLEGAL_ARGUS);
        jsonObject.put("msg", "illegal arguments.");
        return jsonObject.toJSONString();
    }

    /**
     * 返回没有改变
     *
     * @param msg 信息
     * @return
     */
    public static String responseNotChange(String msg) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", ResponseCode.S_NOCHANGE);
        jsonObject.put("msg", msg);
        return jsonObject.toJSONString();
    }

    /**
     * 返回错误
     *
     * @return
     */
    public static String responseError() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", ResponseCode.F_SERVER_ERROR);
        return jsonObject.toJSONString();
    }
}
