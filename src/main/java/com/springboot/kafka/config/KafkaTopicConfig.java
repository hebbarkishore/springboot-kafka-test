//package com.springboot.kafka.config;
//
//import org.apache.kafka.clients.admin.NewTopic;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.config.TopicBuilder;
//
//@Configuration
//public class KafkaTopicConfig {
//	
//	@Bean
//	NewTopic myTopic() {
//		return TopicBuilder.name("myTopic")
//				.partitions(10).build();
//	}
//	
//	@Bean
//	NewTopic userTopic() {
//		return TopicBuilder.name("userTopic")
//				.partitions(10).build();
//	}
//}
