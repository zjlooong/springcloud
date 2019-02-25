package com.zjl.user.service;

import com.zjl.user.bean.UserInfo;

public interface UserService {

    /**
     * 通过openid查询user
     * @param openid
     * @return
     */
    UserInfo getByOpenid(String openid);
}
