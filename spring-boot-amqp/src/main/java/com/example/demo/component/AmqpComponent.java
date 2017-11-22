package com.example.demo.component;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AmqpComponent {

	@Autowired
	private AmqpTemplate amqpTemplate;
	
	public void send(String msg) {
		this.amqpTemplate.convertAndSend("fuyi.queue", msg);
	}
	
	@RabbitListener(queues="fuyi.queue")
	public void receiveQueue(String text) {
		System.out.println("rabbit 接收到 ： " + text);
	}
}
