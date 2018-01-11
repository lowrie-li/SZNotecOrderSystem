package com.SzNotec.OrderSystem.dao;

import com.SzNotec.OrderSystem.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer usersno);

    int insert(User record);

    int insertSelective(User record);

    User selectByUid(User record);
    User selectByPrimaryKey(Integer usersno);
    User userSignIn(User record);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}