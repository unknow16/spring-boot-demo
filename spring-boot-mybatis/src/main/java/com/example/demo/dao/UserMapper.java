package com.example.demo.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import com.example.demo.domain.UserLog;

@Mapper
public interface UserMapper {

	@Insert(value="insert into user_log (id, create_time, user_ip, user_name) "
			+ "values (#{id}, #{createTime}, #{userIp}, #{userName,jdbcType=VARCHAR})")
	int insert(UserLog userLog);
	
	@Delete(value="delete from user_log where id=#{id}")
	void delete(Integer id);
	
	@Update(value="update user_log set user_ip=#{userIp}, user_name=#{userName} where id=#{id}")
	void update(UserLog userLog);
	
	@Select(value="select id, user_name, user_ip, create_time from user_log where id = #{id, jdbcType=INTEGER}")
	@Results(value={
				@Result(column="user_name", property="userName"), 
				@Result(column="user_ip", property="userIp"),
				@Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)})	
	UserLog selectByPrimaryKey(Integer id);
}
