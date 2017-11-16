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
import com.example.demo.mongodb.MongoDBComponent;
import com.example.demo.mongodb.UserLogMongoDao;
import com.example.demo.redis.RedisComponent;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootNosqlApplicationTests {

	@Autowired
	private RedisComponent redisComponent;
	
	@Autowired
	private MongoDBComponent mongoDBComponent;
	
	@Autowired
	private UserLogMongoDao userLogMongoDao;
	
	@Test
	public void contextLoads() {
	}

	/*****************redis test*****************/
	@Test
	public void set() {
		redisComponent.set("fuyi1", "hello world!");
	}
	
	@Test
	public void get() {
		System.out.println(redisComponent.get("fuyi"));
	}
	
	@Test
	public void del() {
		redisComponent.del("fuyi");
	}
	
	/*******************mongoDB test*******************/
	@Test
	public void insert() {
		UserLog userLog = new UserLog();
		
		userLog.setId(2);
		userLog.setCreateTime(new Date());
		userLog.setUserIp("192.168.0.11");
		userLog.setUserName("22222");
		mongoDBComponent.insert(userLog);
	}
	
	@Test
	public void select() {
		System.out.println(mongoDBComponent.selectById(2));
	}
	
	@Test
	public void update() {
		UserLog userLog = new UserLog();
		userLog.setId(1);
		userLog.setCreateTime(new Date());
		userLog.setUserIp("192.168.11.021");
		userLog.setUserName("修改内容");
		mongoDBComponent.updateById(userLog);
	}
	
	@Test 
	public void delete() {
		mongoDBComponent.deleteById(2);
	}
	
	/*******************mongo repository********************************/
	
	@Test
	public void insert1() {
		UserLog userLog = new UserLog();
		userLog.setId(3);
		userLog.setCreateTime(new Date());
		userLog.setUserIp("192.168.0.11");
		userLog.setUserName("3333");
		userLogMongoDao.save(userLog);
	}
	
	@Test
	public void delete1() {
		userLogMongoDao.delete(3);
	}
	
	@Test
	public void update1() {
		UserLog userLog = new UserLog();
		userLog.setId(3);
		userLog.setCreateTime(new Date());
		userLog.setUserIp("192.168.0.11");
		userLog.setUserName("66666");
		userLogMongoDao.save(userLog);
	}
	
	@Test
	public void select1() {
		System.out.println(userLogMongoDao.findOne(3));
	}
	
	@Test
	public void select2() {
		System.out.println(userLogMongoDao.findByUserName("66666"));
	}
	
	@Test
	public void select3() {
		Pageable pageable = new PageRequest(0, 2, new Sort(new Order(Direction.DESC, "id")));
		Page<UserLog> findAll = userLogMongoDao.findAll(pageable);
		System.out.println(" count = " + findAll.getNumberOfElements());
		System.out.println( " page = " + findAll.getSize());
		System.out.println(findAll.getContent());
		//List<UserLog> list = userLogMongoDao.findAll();
		//System.out.println(list);
	}
}
