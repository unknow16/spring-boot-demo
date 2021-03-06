package com.example.demo.component;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class JmsComponent {

	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;
	
	@Autowired
	private Queue queue;
	
	public void send(String msg) {
		this.jmsMessagingTemplate.convertAndSend(this.queue, msg);
	}
	
	@JmsListener(destination="fuyi.queue")
	public void receiveQueue(String text) {
		System.out.println("接收到： " + text);
	}
}
