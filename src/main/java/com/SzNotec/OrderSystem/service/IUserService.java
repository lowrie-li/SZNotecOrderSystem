package com.SzNotec.OrderSystem.service;

import com.SzNotec.OrderSystem.entity.User;

public interface IUserService {
    User signIn(String uid, String pwd);

    boolean signUp(String uid, String pwd);
}
