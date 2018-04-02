package com.miao.Dao;

import com.miao.PoJo.User;


public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey();

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}