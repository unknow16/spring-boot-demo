package com.example.demo.cache.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.example.demo.bean.UserLog;
import com.example.demo.cache.UserLogCache;
import com.example.demo.dao.UserLogDao;

@CacheConfig(cacheNames="fuyiCache")
@Component
public class UserLogCacheImpl implements UserLogCache {

	@Autowired
	private UserLogDao userLogDao;
	
	@Cacheable(key="#p0")
	@Override
	public UserLog selectById(Integer id) {
		System.out.println("查询功能， 缓存中查询不到，读取数据库， id = " + id);
		return userLogDao.selectById(id);
	}

	@CachePut(key="#p0")
	@Override
	public Integer updateById(UserLog userLog) {
		System.out.println("更新功能，更新缓存，直接写库， id = " + userLog);
		return userLogDao.updateById(userLog);
	}

	@CacheEvict(key="#p0")
	@Override
	public Integer deleteById(Integer id) {
		System.out.println("删除功能，删除缓存，直接写库， id = " + id);
		return userLogDao.deleteById(id);
	}

}
