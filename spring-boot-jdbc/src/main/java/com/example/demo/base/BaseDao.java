package com.example.demo.base;

import java.util.List;
import java.util.Map;

public interface BaseDao {

	/**
	 * 获取当前事务最后一次更新的主键值
	 * @return
	 */
	Long getLastId();

	/**
	 * 获取单个对象信息
	 * @param sql
	 * @param clazz
	 * @param args
	 * @return
	 */
	<T> T queryForObject(String sql, Class<T> clazz, Object... args);

	/**
	 * 获对像集合信息
	 * @param sql
	 * @param clazz
	 * @param args
	 * @return
	 */
	<T> List<T> queryForObjectList(String sql, Class<T> clazz, Object... args);

	/**
	 * 分页查询, 不支持like,
	 * @param sql
	 * @param pageCurrent 当前页
	 * @param pageSize 每页记录数
	 * @param args sql参数
	 * @return
	 */
	Page<Map<String, Object>> queryForPage(String sql, int pageCurrent, int pageSize, Object... args);

	<T> Page<T> queryForPage(String sql, int pageCurrent, int pageSize, Class<T> clazz,
			Object... args);

}