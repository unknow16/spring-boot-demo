package com.example.demo;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.UserLogMapper;
import com.example.demo.dao.UserMapper;
import com.example.demo.domain.UserLog;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMybatisApplicationTests {
	
	@Autowired
	//private UserMapper userMapper;
	private UserLogMapper userMapper;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testInsert() {
		UserLog userLog = new UserLog();
		userLog.setCreateTime(new Date());
		userLog.setId(7);
		userLog.setUserIp("192.145.12.12");
		userLog.setUserName("塔顶地");
		userMapper.insert(userLog);
	}
	
/*	@Test 
	public void del() {
		userMapper.delete(1);
	}
	
	@Test
	public void update() {
		UserLog userLog = new UserLog();
		userLog.setCreateTime(new Date());
		userLog.setId(6);
		userLog.setUserIp("192.145.12.12");
		userLog.setUserName("塔顶地1111111");
		userMapper.update(userLog);
	}*/
	
	@Test
	public void testSelect() {
		UserLog ul = userMapper.selectByPrimaryKey(7);
		System.out.println(ul);
	}
}
