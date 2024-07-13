package com.springboot.kafka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.springboot.kafka.payload.User;

@Service
public class KafkaConsumerService {
	
	private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);

	@KafkaListener(topics = "myTopic", groupId="myGroup")
	public void consumer1(String message) {
		logger.info("consumer 1 consuming the message:"+message);
		
	}
	
	@KafkaListener(topics = "myTopic", groupId="myGroup")
	public void consumer2(String message) {
		logger.info("consumer 2 consuming message:"+message);
		
	}
	
	@KafkaListener(topics = "myTopic", groupId="myGroup")
	public void consumer3(String message) {
		logger.info("consumer 3 consuming the message:"+message);
		
	}
	
	@KafkaListener(topics = "myTopic", groupId="myGroup")
	public void consumer4(String message) {
		logger.info("consumer 4 consuming the message:"+message);
		
	}
	
	@KafkaListener(topics = "userTopic", groupId="myGroup")
	public void consume_user(User user) {
		logger.info("consuming user message:"+user);
	}

}
