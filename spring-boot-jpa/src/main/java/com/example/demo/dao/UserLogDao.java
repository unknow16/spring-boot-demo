package com.example.demo.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.bean.UserLog;

public interface UserLogDao extends JpaRepository<UserLog, Integer> {

	List<UserLog> findByUserName(String string);

	List<UserLog> findByUserNameAndUserIp(String string, String string2);

	Page<UserLog> findByUserName(String string, Pageable pageable);

	
}
