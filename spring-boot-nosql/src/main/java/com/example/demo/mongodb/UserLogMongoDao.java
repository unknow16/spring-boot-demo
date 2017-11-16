package com.example.demo.mongodb;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.bean.UserLog;

public interface UserLogMongoDao extends MongoRepository<UserLog, Integer> {

	UserLog findByUserName(String string);
	UserLog findByUserNameAndUserIp(String userName, String ip);
	Page<UserLog> findByUserName(String userName, Pageable pageable);
}
