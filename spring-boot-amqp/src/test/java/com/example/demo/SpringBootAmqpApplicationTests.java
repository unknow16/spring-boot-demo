package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.component.AmqpComponent;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootAmqpApplicationTests {

	@Autowired
	private AmqpComponent amqpComponent;
	
	@Test
	public void contextLoads() {
	}

	@Test
	public void send() {
		amqpComponent.send("Hello rabbit....");
	}
}
