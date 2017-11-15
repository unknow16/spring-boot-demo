package com.example.demo;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.bean.UserLog;
import com.example.demo.dao.UserLogDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootJpaApplicationTests {
	
	@Autowired
	private UserLogDao userLogDao;

	@Test
	public void contextLoads() {
	}

	@Test
	public void insert() {
		UserLog userLog = new UserLog();
		userLog.setCreateTime(new Date());
		userLog.setUserIp("192.168.11.0");
		userLog.setUserName("老北京3");
		userLogDao.save(userLog);
	}
	
	@Test
	public void delete() {
		userLogDao.delete(2);;
	}
	
	@Test
	public void update() {
		UserLog userLog = new UserLog();
		userLog.setId(1);
		userLog.setCreateTime(new Date());
		userLog.setUserIp("192.168.11.1");
		userLog.setUserName("老北京1");
		userLogDao.save(userLog);
	}
	
	@Test
	public void select() {
		UserLog findOne = userLogDao.findOne(1);
		System.out.println(findOne);
	}
	
	@Test
	public void select1() {
		List<UserLog> list = userLogDao.findByUserName("老北京2");
		System.out.println(list);
	}
	
	@Test
	public void select2() {
		List<UserLog> list = userLogDao.findByUserNameAndUserIp("老北京3","192.168.11.0");
		System.out.println(list);
	}
	
	@Test
	public void selectForPage() {
		Pageable pageable = new PageRequest(1, 2, new Sort(new Order(Direction.DESC, "id")));
		//Page<UserLog> result = userLogDao.findByUserName("老北京2", pageable);
		Page<UserLog> result = userLogDao.findAll(pageable);
		System.out.println("total count == " + result.getTotalElements());
		System.out.println("page == " + result.getTotalPages());
		System.out.println(result.getContent());
	}
}


