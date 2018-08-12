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
    EasemobUserService easemobService;

    @Autowired
    EMUserService userService;

    @RequestMapping("/register/single")
    @ResponseBody
    public String registerSingle(@RequestParam(value = "username", defaultValue = "", required = false) String username,
                                 @RequestParam(value = "nickname", defaultValue = "", required = false) String nickname){
        if (StringUtils.isBlank(username)){
            return ResponseUtil.responseIllegalArgus();
        }
        //检查用户名在不在
        EaseMobUser user = userService.getUser(username);
        if (user != null){
            return ResponseUtil.responseNotChange("user is exist.");
        }
        String password = PasswordUtil.genPassword();
        EaseMobUser emUser = null;
        try {
            emUser = easemobService.registerSingle(username, password, nickname);
        } catch (BaseException e) {
            return ResponseUtil.responseError();
        }
        if (emUser != null){
            userService.addUser(emUser);
        }
        return ResponseUtil.responseOk(null);
    }

}
