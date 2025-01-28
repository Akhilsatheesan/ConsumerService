package com.shopping.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.consumer.dto.ConsumerCred;
import com.shopping.consumer.dto.ConsumerDto;
import com.shopping.consumer.service.ConsumerService;

@RequestMapping("/api")
@RestController
public class ConsumerController {

	@Autowired
	ConsumerService service;

	@PostMapping("/userRegistration")
	public String addUser(@RequestBody ConsumerDto consumerData) {
		String message = service.saveUser(consumerData);
		return message;
	}

	@PostMapping("/userCreds")
	public String addUserCred(@RequestBody ConsumerCred consumerCred) {
		String message = service.saveCred(consumerCred);
		return message;
	}

}
