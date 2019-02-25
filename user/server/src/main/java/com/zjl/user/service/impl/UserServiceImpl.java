package com.zjl.user.service.impl;

import com.zjl.user.bean.UserInfo;
import com.zjl.user.dao.UserInfoDao;
import com.zjl.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public UserInfo getByOpenid(String openid) {
        return userInfoDao.getByOpenid(openid);
    }
}
