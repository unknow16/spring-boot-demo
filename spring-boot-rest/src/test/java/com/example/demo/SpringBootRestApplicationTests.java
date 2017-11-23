package com.example.demo;

import java.util.HashMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.bean.UserLog;
import com.example.demo.proxy.ProxyCustomizer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRestApplicationTests {

	@Autowired
	private RestTemplateBuilder restTemplateBuilder;
	
	@Test
	public void contextLoads() {
	}

	/**
	 * 使用template
	 */
	@Test
	public void getForObject() {
		UserLog o = restTemplateBuilder.build().getForObject("http://localhost:1111/rest/get/{id}", UserLog.class, 4);
		System.out.println(o);
		
		//UserLog ul = restTemplateBuilder.build().getForObject("http://localhost:1111/rest/update/{id}", UserLog.class, 4);
		//System.out.println(ul);
		
		
	
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", 4);
		map.put("userName", "4444");
		UserLog ul = restTemplateBuilder.build().postForObject("http://localhost:1111/rest/update", map, UserLog.class);
		System.out.println(ul);
	}
	
	/**
	 * spring 代理实现
	 */
	@Test
	public void test1() {
		String result = restTemplateBuilder.additionalCustomizers(new ProxyCustomizer()).build().getForObject("http://www.baidu.com", String.class);
		System.out.println(result);
		
	}
}
