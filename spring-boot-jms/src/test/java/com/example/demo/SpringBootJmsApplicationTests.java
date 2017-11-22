package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.component.JmsComponent;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootJmsApplicationTests {
	
	@Autowired
	private JmsComponent jmsComponent;

	@Test
	public void contextLoads() {
	}

	@Test
	public void send() {
		jmsComponent.send("hello world222");
	}
}
