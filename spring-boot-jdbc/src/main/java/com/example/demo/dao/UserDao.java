package com.example.demo.dao;

import com.example.demo.base.BaseDao;
import com.example.demo.bean.User;

public interface UserDao extends BaseDao {

	int insert(User user);
	int deleteById(int id);
	int updateById(User user);
	User selectById(int id);
}
