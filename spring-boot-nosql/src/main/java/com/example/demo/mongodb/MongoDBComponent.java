package com.example.demo.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.example.demo.bean.UserLog;

@Component
public class MongoDBComponent {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	public void insert(UserLog userLog) {
		mongoTemplate.insert(userLog);
	}
	
	public void deleteById(int id) {
		Criteria criteria = Criteria.where("id").in(id);
		Query query = new Query(criteria);
		mongoTemplate.remove(query, UserLog.class);
	}
	
	public void updateById(UserLog userLog) {
		Criteria criteria = Criteria.where("id").in(userLog.getId());
		Query query = new Query(criteria);
		
		Update update = new Update();
		update.set("userName", userLog.getUserName());
		update.set("createTime", userLog.getCreateTime());
		update.set("userIp", userLog.getUserIp());
		mongoTemplate.updateMulti(query, update, UserLog.class);
	}
	
	public UserLog selectById(int id) {
		Criteria criteria = Criteria.where("id").in(id);
		Query query = new Query(criteria);
		return mongoTemplate.findOne(query, UserLog.class);
	}
}
