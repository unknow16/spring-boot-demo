package com.example.demo.base;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;


public class BaseDaoImpl implements BaseDao {

	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	/* (non-Javadoc)
	 * @see com.example.demo.base.BaseDao#getLastId()
	 */
	@Override
	public Long getLastId() {
		return jdbcTemplate.queryForObject("select last_insert_id() as id", Long.class);
	}
	
	/* (non-Javadoc)
	 * @see com.example.demo.base.BaseDao#queryForObject(java.lang.String, java.lang.Class, java.lang.Object)
	 */
	@Override
	public <T> T queryForObject(String sql, Class<T> clazz, Object... args) {
		Assert.hasText(sql, "sql语句不能为空");
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(clazz), args);
	}
	
	/* (non-Javadoc)
	 * @see com.example.demo.base.BaseDao#queryForObjectList(java.lang.String, java.lang.Class, java.lang.Object)
	 */
	@Override
	public <T> List<T> queryForObjectList(String sql, Class<T> clazz, Object... args) {
		Assert.hasText(sql, "sql语句不能为空");
		return jdbcTemplate.query(sql, args, new BeanPropertyRowMapper<T>(clazz));
	}
	
	/* (non-Javadoc)
	 * @see com.example.demo.base.BaseDao#queryForPage(java.lang.String, int, int, java.lang.Object)
	 */
	@Override
	public Page<Map<String, Object>> queryForPage(String sql, int pageCurrent, int pageSize, Object... args) {
		
		String countSql = Sql.countSql(sql);
		//总记录数
		int totalCount = jdbcTemplate.queryForObject(countSql, Integer.class, args);
		//校验当前页（如果页面提交过来的页数大于总页数，则将当前页设为总页数，小于则返回1）
		pageCurrent = Sql.checkPageCurrent(totalCount, pageSize, pageCurrent);
		//校验每页显示记录数
		pageSize = Sql.checkPageSize(pageSize);
		//计算总页数
		int totalPage = Sql.countTotalPage(totalCount, pageSize);
		
		//拼接limit子句
		String sqlList = sql + Sql.limitSql(totalCount, pageCurrent, pageSize);
		
		//查询
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sqlList, args);
		return new Page<Map<String, Object>>(totalCount, totalPage, pageCurrent, pageSize, list);
	}
	
	/* (non-Javadoc)
	 * @see com.example.demo.base.BaseDao#queryForPage(java.lang.String, int, int, java.lang.Class, java.lang.Object)
	 */
	@Override
	public <T> Page<T> queryForPage(String sql, int pageCurrent, int pageSize, Class<T> clazz, Object... args) {
		String countSql = Sql.countSql(sql);
		//总记录数
		int totalCount = jdbcTemplate.queryForObject(countSql, Integer.class, args);
		//校验当前页（如果页面提交过来的页数大于总页数，则将当前页设为总页数，小于则返回1）
		pageCurrent = Sql.checkPageCurrent(totalCount, pageSize, pageCurrent);
		//校验每页显示记录数
		pageSize = Sql.checkPageSize(pageSize);
		//计算总页数
		int totalPage = Sql.countTotalPage(totalCount, pageSize);
		
		//拼接limit子句
		String sqlList = sql + Sql.limitSql(totalCount, pageCurrent, pageSize);
		
		//查询
		List<T> list = jdbcTemplate.query(sqlList,new BeanPropertyRowMapper<T>(clazz), args);
		return new Page<T>(totalCount, totalPage, pageCurrent, pageSize, list);
	}
} 
