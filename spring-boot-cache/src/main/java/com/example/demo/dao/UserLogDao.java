package com.example.demo.dao;

import com.example.demo.bean.UserLog;

public interface UserLogDao {

	UserLog selectById(Integer id);
	
	Integer updateById(UserLog userLog);
	
	Integer deleteById(Integer id);
}
