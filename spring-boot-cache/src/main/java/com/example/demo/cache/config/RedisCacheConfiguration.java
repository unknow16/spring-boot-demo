package com.example.demo.cache.config;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * redis 自定义缓存配置类
 * @author Administrator
 *
 */
@Configuration
public class RedisCacheConfiguration extends CachingConfigurerSupport {

	/**
	 * 自定义缓存管理器
	 * @param redisTemplate
	 * @return
	 */
	@Bean
	public CacheManager cacheManager(RedisTemplate<?, ?> redisTemplate) {
		RedisCacheManager redisCacheManager = new RedisCacheManager(redisTemplate);
		
		//设置默认的过期时间
		redisCacheManager.setDefaultExpiration(20);
		
		//单独设置
		/*Map<String, Long> expires = new HashMap<String, Long>();
		expires.put("fuyiCache", 200L);
		redisCacheManager.setExpires(expires);*/
		return redisCacheManager;
	}
	
	/**
	 * 自定义key的生成策略
	 * 根据类名+方法名+所以参数的值生成唯一的一个key
	 * 即使@Cacheable中的value属性一样，key也会不一样
	 */
	@Override
	public KeyGenerator keyGenerator() {
		/*return new KeyGenerator() {
			
			@Override
			public Object generate(Object o, Method method, Object... args) {
				StringBuffer sb = new StringBuffer();
				sb.append(o.getClass().getName());
				sb.append(method.getName());
				for(Object arg : args) {
					sb.append(arg.toString());
				}
				return sb.toString();
			}
		};*/
		
		return (Object o, Method method, Object... args) -> {
			StringBuffer sb = new StringBuffer();
			sb.append(o.getClass().getName());
			sb.append(method.getName());
			for(Object arg : args) {
				sb.append(arg.toString());
			}
			return sb.toString();
		};
	}
}
