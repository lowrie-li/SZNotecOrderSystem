package com.SzNotec.OrderSystem.service.impl;

import com.SzNotec.OrderSystem.dao.UserMapper;
import com.SzNotec.OrderSystem.entity.User;
import com.SzNotec.OrderSystem.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService implements IUserService{

    @Resource
    UserMapper uMap;

    public User signIn(String uid, String pwd) {
        if (null == uid || null == pwd || 0 == uid.length() + pwd.length()) {
            return null;
        }

        User user = new User();
        user.setUid(uid);
        user.setPwd(pwd);
        return uMap.userSignIn(user);
    }

    public boolean signUp(String uid, String pwd) {
        if (null == uid || null == pwd || 0 == uid.length() + pwd.length()) {
            return false;
        }

        User user = new User();
        user.setUid(uid);
        user.setPwd(pwd);

        if (uMap.selectByUid(user) != null) {
            return uMap.insertSelective(user) == 1;
        } else {
            return false;
        }
    }
}
