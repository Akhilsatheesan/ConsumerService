package com.shopping.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.consumer.dto.ConsumerCred;
import com.shopping.consumer.dto.ConsumerDto;
import com.shopping.consumer.model.ConsumerCredEntity;
import com.shopping.consumer.model.ConsumerEntity;
import com.shopping.consumer.repository.ConsumerCredRepo;
import com.shopping.consumer.repository.ConsumerRepo;

@Service
public class ConsumerServiceImpl implements ConsumerService {

	@Autowired
	ConsumerRepo repo;

	@Autowired
	ConsumerCredRepo credRepo;

	@Override
	public String saveUser(ConsumerDto user) {
		String message = "Success";
		if (repo.existsByEmail(user.getEmail()) || repo.existsByMobNumber(user.getMobNumber())) {
			return "Mob Number or Email already Exists..!!!";
		}
		try {
			repo.save(mapToEntity(user));
		} catch (Exception exception) {
			message = "failed to save the data";
		}
		ConsumerCredEntity credEntity = new ConsumerCredEntity();
		credEntity.setUserName(user.getEmail());
		credRepo.save(credEntity);
		return message;
	}

	private ConsumerEntity mapToEntity(ConsumerDto userData) {
		ConsumerEntity entity = new ConsumerEntity();
		entity.setEmail(userData.getEmail());
		entity.setFirstName(userData.getFirstName());
		entity.setLastName(userData.getLastName());
		entity.setMobNumber(userData.getMobNumber());
		entity.setUserName(userData.getEmail());
		return entity;
	}

	@Override
	public String saveCred(ConsumerCred cred) {
		int rows = credRepo.updatePassword(cred.getUserName(), cred.getPassword());
		if (rows > 0) {
			return "Password Created";
		}
		return "Account not created";
	}
}