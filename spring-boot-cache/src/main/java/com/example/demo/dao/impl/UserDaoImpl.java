package com.example.demo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.bean.UserLog;
import com.example.demo.dao.UserLogDao;

@Repository
public class UserDaoImpl implements UserLogDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public UserLog selectById(Integer id) {
		String sql = "select * from user_log where id=?";
		return jdbcTemplate.queryForObject(sql, new RowMapper<UserLog>() {

			@Override
			public UserLog mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserLog ul = new UserLog();
				ul.setCreateTime(rs.getDate("create_time"));
				ul.setId(rs.getInt("id"));
				ul.setUserIp(rs.getString("user_ip"));
				ul.setUserName(rs.getString("user_name"));
				return ul;
			}
			
		}, id);
	}

	@Override
	public Integer updateById(UserLog userLog) {
		String sql = "update user_log set create_time=?, user_ip=?, user_name=? where id=?";
		return jdbcTemplate.update(sql, userLog.getCreateTime(), userLog.getUserIp(), userLog.getUserName(), userLog.getId());
	}

	@Override
	public Integer deleteById(Integer id) {
		String sql = "delete from user_log where id = ?";
		return jdbcTemplate.update(sql, id);
	}

}
