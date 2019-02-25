package com.zjl.user.dao;

import com.zjl.user.bean.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoDao extends JpaRepository<UserInfo,String> {
    UserInfo getByOpenid(String openid);
}
