package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.bean.UserLog;
import com.example.demo.cache.UserLogCache;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootCacheApplicationTests {
	
	@Autowired
	private UserLogCache userLogCache;

	@Test
	public void contextLoads() {
	}

	
	@Test
	public void testSelect()  {
		UserLog ul = userLogCache.selectById(4);
		System.out.println(ul);
	}
	
	@Test
	public void testUpdate() {
		UserLog userLog = new UserLog();
		userLog.setId(1);
		userLog.setUserName("老北京111111");
		userLogCache.updateById(userLog);
		System.err.println(userLogCache.selectById(1));
	}
	
	@Test
	public void testDelte() {
		userLogCache.deleteById(1);
	}
}
