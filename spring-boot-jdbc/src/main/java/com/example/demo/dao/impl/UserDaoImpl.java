package com.example.demo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.base.BaseDaoImpl;
import com.example.demo.bean.User;
import com.example.demo.dao.UserDao;

@Repository
public class UserDaoImpl extends BaseDaoImpl implements UserDao {

	@Override
	public int insert(User user) {
		String sql = "insert into user (id, username, birthday, sex, address) values (?, ?, ?, ?, ?)";
		return jdbcTemplate.update(sql, user.getId(), user.getUsername(), user.getBirthday(), user.getSex(), user.getAddress());
	}

	@Override
	public int deleteById(int id) {
		String sql = "delete from user where id = ?";
		return jdbcTemplate.update(sql, id);
	}

	@Override
	public int updateById(User user) {
		String sql = "update user set username=?, birthday=?, sex=?, address=? where id=?";
		return jdbcTemplate.update(sql, user.getUsername(), user.getBirthday(), user.getSex(), user.getAddress(), user.getId());
	}

	@Override
	public User selectById(int id) {
		String sql = "select * from user where id=?";
		return jdbcTemplate.queryForObject(sql, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setBirthday(rs.getDate("birthday"));
				user.setSex(rs.getString("sex"));
				user.setAddress(rs.getString("address"));
				return user;
			}
			
		}, id);
	}
	
	
}
