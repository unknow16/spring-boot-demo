package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.UserLog;

@Mapper
public interface UserLogMapper {

	int insert(UserLog userLog);

	UserLog selectByPrimaryKey(Integer id);
}
