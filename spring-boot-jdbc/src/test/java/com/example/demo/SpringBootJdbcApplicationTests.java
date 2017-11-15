package com.example.demo;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.base.Page;
import com.example.demo.base.Sql;
import com.example.demo.bean.User;
import com.example.demo.dao.UserDao;
import com.mysql.jdbc.StringUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootJdbcApplicationTests {
	
	@Autowired
	private UserDao userDao;

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void insert() {
		User user = new User();
		user.setId(5);
		user.setAddress("郑州");
		user.setBirthday(new Date());
		user.setSex("男");
		user.setUsername("付一");
		
		userDao.insert(user);
	}

	@Test
	public void delete() {
		userDao.deleteById(1);
	}
	
	@Test
	public void update() {
		User user = new User();
		user.setId(5);
		user.setAddress("郑州");
		user.setBirthday(new Date());
		user.setSex("女");
		user.setUsername("付一");
		userDao.updateById(user);
	}

	@Test
	public void query() {
		User user = userDao.selectById(5);
		System.out.println(user);
	}
	
	@Test
	public void testPage() {
		String sql = "select * from user";
		Page<User> page = userDao.queryForPage(sql, 2, 2, User.class, null);
		System.out.println("总页数===" + page.getTotalPage());
		System.out.println("总记录数===" + page.getTotalCount());
		List<User> list = page.getList();
		for (User map : list) {
			System.out.println(map);
		}
	}
	
	@Test
	public void testPageLike() {
		StringBuffer sb = new StringBuffer("select * from user where 1");
		sb.append(" and username like '%").append(Sql.checkSql("付一")).append("%'");
		Page<User> page = userDao.queryForPage(sb.toString(), 2, 2, User.class, null);
		System.out.println("总页数===" + page.getTotalPage());
		System.out.println("总记录数===" + page.getTotalCount());
		List<User> list = page.getList();
		for (User map : list) {
			System.out.println(map);
		}
	}
}


