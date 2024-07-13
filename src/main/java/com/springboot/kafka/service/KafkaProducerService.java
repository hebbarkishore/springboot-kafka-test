package com.springboot.kafka.service;


import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import com.springboot.kafka.payload.User;

@Service
public class KafkaProducerService {
	
	private static final Logger logger = LoggerFactory.getLogger(KafkaProducerService.class);

	@Autowired
	private KafkaTemplate<String, String> kafkaStringTemplate;

	@Autowired
	private KafkaTemplate<String, User> kafkaUserTemplate;
	
	/**
	 * Sending string message
	 * @param message
	 */
	public void sendMessage_string(String message) {
		logger.info(String.format("Message Sent %s", message));
		CompletableFuture<SendResult<String, String>> future = kafkaStringTemplate.send("myTopic", message);
		future.whenComplete((result, ex) -> {
			if( ex == null ) {
				logger.info("successfully sent the message to Kafka, offset is:"+result.getRecordMetadata().offset());
			} else {
				logger.error("Exception while sending the data to Kafka:"+ex);
			}				
		});
	}
	
	
	/**
	 * Sending object message
	 * @param user
	 */
	public void sendMessage_user(User user) {
		logger.info("Sending user:"+user);
		Message<User> message = MessageBuilder
				.withPayload(user)
				.setHeader(KafkaHeaders.TOPIC, "userTopic")
				.build();
		kafkaUserTemplate.send(message);
	}
}
