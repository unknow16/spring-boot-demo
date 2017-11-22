package com.example.demo.web;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.UserLog;
import com.example.demo.cache.UserLogCache;

@RestController
public class IndexController {

	@Autowired
	private UserLogCache userLogCache;
	
	@RequestMapping(value="/select", method=RequestMethod.GET)
	public UserLog get(@RequestParam(defaultValue="1") Integer id) {
		return userLogCache.selectById(id);
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public UserLog update(@RequestParam(defaultValue="3") Integer id) {
		UserLog userLog = new UserLog();
		userLog.setId(3);
		userLog.setCreateTime(new Date());
		userLog.setUserIp("192.168.11.333");
		userLog.setUserName("老北京333333");
		userLogCache.updateById(userLog);
		return userLog;
	}
	
	@RequestMapping(value="/del", method=RequestMethod.GET)
	public String del(@RequestParam(defaultValue="3") Integer id){
		userLogCache.deleteById(id);
		return "清空缓存成功";
	}
}
