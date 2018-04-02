package com.miao.Impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.miao.Dao.UserMapper;
import com.miao.PoJo.User;
import com.miao.Service.userService;

@Service
public class UserServiceImpl implements userService {

	@Resource
	UserMapper userMapper;
	public User getUser() {
		return userMapper.selectByPrimaryKey();
	}

}
