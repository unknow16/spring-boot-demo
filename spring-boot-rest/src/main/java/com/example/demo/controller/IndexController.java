package com.example.demo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.UserLog;
import com.example.demo.dao.UserLogDao;
import com.fasterxml.jackson.databind.JsonNode;

@RestController
@RequestMapping(value="/rest", method = RequestMethod.POST)
public class IndexController {

	@Autowired
	private UserLogDao userLogDao;
	
	@RequestMapping(value="/get/{id}", method = RequestMethod.GET)
	public UserLog getById(@PathVariable(value="id") Integer id) {
		return userLogDao.findOne(id);
	}
	
	@RequestMapping(value="/update")
	public UserLog update(@RequestBody JsonNode jsonNode) {
		System.out.println("json Node = " + jsonNode);
		UserLog ul = userLogDao.findOne(4);
		if(ul == null) {
			ul = new UserLog();
		}
		ul.setCreateTime(new Date());
		ul.setId(4);
		ul.setUserIp("192.168.99.0");
		ul.setUserName("fuyasdfasdfi");
		userLogDao.save(ul);
		return ul;
	}
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	public UserLog update2(@PathVariable(value="id") Integer id) {
		UserLog ul = userLogDao.findOne(id);
		if(ul == null) {
			ul = new UserLog();
		}
		ul.setCreateTime(new Date());
		ul.setId(id);
		ul.setUserIp("192.168.99.0");
		ul.setUserName("fuyi444");
		userLogDao.save(ul);
		return ul;
	}
}
