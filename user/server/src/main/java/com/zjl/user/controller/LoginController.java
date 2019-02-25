package com.zjl.user.controller;

import com.zjl.user.bean.UserInfo;
import com.zjl.user.constane.CookieConstant;
import com.zjl.user.constane.RedisConstant;
import com.zjl.user.enums.ResultEnum;
import com.zjl.user.enums.RoleEnum;
import com.zjl.user.service.UserService;
import com.zjl.user.utils.CookieUtil;
import com.zjl.user.vo.InvokeResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 买家端登录
     * @param openid
     * @param response
     * @return
     */
    @GetMapping("buyer")
    public InvokeResult buyer(@RequestParam String openid, HttpServletResponse response){
        // 查询user
        UserInfo userInfo = userService.getByOpenid(openid);
        if (userInfo == null){
            return InvokeResult.failure(ResultEnum.LOGIN_FAIL);
        }
        // 判断角色
        if (userInfo.getRole() != RoleEnum.BUYER.getCode()){
            return InvokeResult.failure(ResultEnum.ROLE_ERROR);
        }

        // 设置cookie
        CookieUtil.set(response, CookieConstant.OPENID, openid,CookieConstant.EXPIRE);

        return InvokeResult.success();
    }

    /**
     * 卖家端登录
     * @param openid
     * @param response
     * @return
     */
    @GetMapping("saller")
    public InvokeResult saller(@RequestParam String openid, HttpServletRequest request, HttpServletResponse response){

        // 避免重复登录
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        if (cookie != null && !StringUtils.isEmpty(redisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_TEMPLATE,cookie.getValue())))){
            return InvokeResult.success();
        }

        // 查询user
        UserInfo userInfo = userService.getByOpenid(openid);
        if (userInfo == null){
            return InvokeResult.failure(ResultEnum.LOGIN_FAIL);
        }
        // 判断角色
        if (userInfo.getRole() != RoleEnum.SALER.getCode()){
            return InvokeResult.failure(ResultEnum.ROLE_ERROR);
        }

        // 写入redis
        String token = UUID.randomUUID().toString();
        redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_TEMPLATE,token),
                openid,
                CookieConstant.EXPIRE,
                TimeUnit.SECONDS);

        // 设置cookie
        CookieUtil.set(response, CookieConstant.TOKEN, token,CookieConstant.EXPIRE);

        return InvokeResult.success();
    }
}
