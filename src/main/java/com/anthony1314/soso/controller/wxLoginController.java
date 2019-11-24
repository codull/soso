package com.anthony1314.soso.controller;

import com.anthony1314.soso.common.HttpClientUtil;
import com.anthony1314.soso.common.JSONResult;
import com.anthony1314.soso.common.JsonUtils;
import com.anthony1314.soso.entity.wxSessionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: soso
 * @description: 授权登录控制器
 * @author: anthony1314
 * @create: 2019-11-22 16:46
 **/

@RestController
@RequestMapping("/login")
public class wxLoginController {

//    @Autowired
//    private RedisOperator redis;


        @RequestMapping(value = "/Login", method = RequestMethod.POST)
    public JSONResult wxLogin(String code) {

        System.out.println("wxlogin - code: " + code);

//		https://api.weixin.qq.com/sns/jscode2session?
//				appid=APPID&
//				secret=SECRET&
//				js_code=JSCODE&
//				grant_type=authorization_code

        String url = "https://api.weixin.qq.com/sns/jscode2session";
        String secret = "481931c5b0d77fa762dd25ead622daf8";
        String appid = "wx721bd7c562d54110";
        Map<String, String> param = new HashMap<>();
        param.put("appid", appid);
        param.put("secret", secret);
        param.put("js_code", code);
        param.put("grant_type", "authorization_code");

        String wxResult = HttpClientUtil.doGet(url, param);
        System.out.println(wxResult);

        wxSessionEntity model = JsonUtils.jsonToPojo(wxResult, wxSessionEntity.class);

        // 存入session到redis
//        redis.set("user-redis-session:" + model.getOpenid(),
//                model.getSession_key(),
//                1000 * 60 * 30);

        return JSONResult.ok();
    }

}
