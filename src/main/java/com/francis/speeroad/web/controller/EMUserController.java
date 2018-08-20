package com.francis.speeroad.web.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.francis.speeroad.entity.EaseMobUser;
import com.francis.speeroad.exception.BaseException;
import com.francis.speeroad.service.EMUserService;
import com.francis.speeroad.service.EasemobUserService;
import com.francis.speeroad.util.PasswordUtil;
import com.francis.speeroad.web.response.ResponseUtil;

/**
 * @author hzzhugequn
 * @date 2018/8/4
 * @since JDK 1.8
 */
@Controller
public class EMUserController {

    @Autowired


    @RequestMapping("/register")
    @ResponseBody
    public String register(@RequestParam(value = "username", defaultValue = "", required = false)String username,
                           @RequestParam(value = "password", defaultValue = "", required = false)String password){
        if (StringUtils.isBlank(username)){
            return ResponseUtil.responseIllegalArgus("用户名为空");
        }
        if (StringUtils.isBlank(password)){
            return ResponseUtil.responseIllegalArgus("密码为空");
        }

        return "hello";
    }
}
