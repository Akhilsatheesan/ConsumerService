package com.shopping.consumer.service;

import com.shopping.consumer.dto.ConsumerCred;
import com.shopping.consumer.dto.ConsumerDto;

public interface ConsumerService {
	
	public String saveUser(ConsumerDto user);
	public String saveCred(ConsumerCred cred);

}