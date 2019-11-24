package com.anthony1314.soso.entity;

/**
 * @program: soso
 * @description: 封装openid和session_key的实体类
 * @author: anthony1314
 * @create: 2019-11-22 16:44
 **/

public class wxSessionEntity {
    public String getSession_key() {
        return session_key;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    private String session_key;
    private String openid;
}
