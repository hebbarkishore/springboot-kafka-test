package com.springboot.kafka.controller;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.kafka.payload.User;
import com.springboot.kafka.service.KafkaProducerService;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {
	
	@Autowired
	private KafkaProducerService service;

	@GetMapping("/publish/text")
	public ResponseEntity<String> publish(@RequestParam("messgae") String message) {
		service.sendMessage_string(message);
		return ResponseEntity.ok("Response Sent");
	}
	
	@PostMapping("/publish/user")
	public ResponseEntity<String> publishUser(@RequestBody User user) {
		service.sendMessage_user(user);
		return ResponseEntity.ok("Json message accepted");
	}
}
