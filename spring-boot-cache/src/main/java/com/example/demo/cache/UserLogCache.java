package com.example.demo.cache;

import com.example.demo.bean.UserLog;

public interface UserLogCache {
	UserLog selectById(Integer id);

	Integer updateById(UserLog userLog);

	Integer deleteById(Integer id);
}
